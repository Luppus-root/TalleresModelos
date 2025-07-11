"use client";

import { useState, useEffect, createContext, useContext } from "react";
import Header from "./components/Header";
import HomePage from "./pages/HomePage";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";
import ProfessionalProfile from "./pages/ProfessionalProfile";
import BookingPage from "./pages/BookingPage";
import MyBookingsPage from "./pages/MyBookingsPage";
import ProfilePage from "./pages/ProfilePage";
import FavoritesPage from "./pages/FavoritesPage";
import NotificationsPage from "./pages/NotificationsPage";
import ChatPage from "./pages/ChatPage";
import { mockData } from "./data/mockData";

import "./styles/base.css";

// Context para el estado global de la aplicación
const AppContext = createContext();

export const useApp = () => {
  const context = useContext(AppContext);
  if (!context) {
    throw new Error("useApp must be used within AppProvider");
  }
  return context;
};

function App() {
  const [currentView, setCurrentView] = useState("home");
  const [user, setUser] = useState(null);
  const [selectedProfessional, setSelectedProfessional] = useState(null);
  const [selectedService, setSelectedService] = useState(null);
  const [selectedProfessionalForChat, setSelectedProfessionalForChat] =
    useState(null);
  const [professionals, setProfessionals] = useState([]);
  const [services, setServices] = useState([]);
  const [reviews, setReviews] = useState([]);
  const [bookings, setBookings] = useState([]);
  const [favorites, setFavorites] = useState([]);
  const [notifications, setNotifications] = useState([]);
  const [loading, setLoading] = useState(true);
  const [filters, setFilters] = useState({
    area: "",
    service: "",
    priceRange: "",
    rating: "",
    search: "",
  });

  useEffect(() => {
    // Simular carga inicial de datos
    setTimeout(() => {
      setProfessionals(mockData.professionals);
      setServices(mockData.services);
      setReviews(mockData.reviews);
      setBookings(mockData.bookings);
      setFavorites(mockData.favorites);
      setNotifications(mockData.notifications);

      // Verificar si hay usuario logueado en localStorage
      const savedUser = localStorage.getItem("beautyAtHomeUser");
      if (savedUser) {
        setUser(JSON.parse(savedUser));
      }

      setLoading(false);
    }, 1500);
  }, []);

  const login = (userData) => {
    setUser(userData);
    localStorage.setItem("beautyAtHomeUser", JSON.stringify(userData));
    setCurrentView("home");
  };

  const logout = () => {
    setUser(null);
    localStorage.removeItem("beautyAtHomeUser");
    setCurrentView("home");
  };

  const register = (userData) => {
    const newUser = {
      ...userData,
      id: Date.now(),
      avatar: "/placeholder.svg?height=100&width=100",
      joinDate: new Date().toISOString(),
      bookingsCount: 0,
      favoriteCount: 0,
    };
    setUser(newUser);
    localStorage.setItem("beautyAtHomeUser", JSON.stringify(newUser));
    setCurrentView("home");
  };

  const handleViewProfessional = (professional) => {
    setSelectedProfessional(professional);
    setCurrentView("professional");
  };

  const handleBookService = (professional, service) => {
    setSelectedProfessional(professional);
    setSelectedService(service);
    setCurrentView("booking");
  };

  const handleContactProfessional = (professional) => {
    if (!user) {
      setCurrentView("login");
      return;
    }
    setSelectedProfessionalForChat(professional);
    setCurrentView("chat");
  };

  const addBooking = (bookingData) => {
    const newBooking = {
      id: Date.now(),
      ...bookingData,
      status: "confirmed",
      createdAt: new Date().toISOString(),
    };
    setBookings((prev) => [...prev, newBooking]);

    // Agregar notificación
    const notification = {
      id: Date.now() + 1,
      type: "booking_confirmed",
      title: "¡Cita confirmada!",
      message: `Tu cita con ${bookingData.professionalName} ha sido confirmada para el ${bookingData.date} a las ${bookingData.time}`,
      date: new Date().toISOString(),
      read: false,
    };
    setNotifications((prev) => [notification, ...prev]);

    setCurrentView("my-bookings");
  };

  const toggleFavorite = (professionalId) => {
    if (!user) {
      setCurrentView("login");
      return;
    }

    const isCurrentlyFavorite = favorites.some(
      (fav) => fav.userId === user.id && fav.professionalId === professionalId
    );

    if (isCurrentlyFavorite) {
      setFavorites((prev) =>
        prev.filter(
          (fav) =>
            !(fav.userId === user.id && fav.professionalId === professionalId)
        )
      );
    } else {
      const newFavorite = {
        id: Date.now(),
        userId: user.id,
        professionalId: professionalId,
        addedAt: new Date().toISOString(),
      };
      setFavorites((prev) => [...prev, newFavorite]);
    }
  };

  const cancelBooking = (bookingId) => {
    setBookings((prev) =>
      prev.map((booking) =>
        booking.id === bookingId ? { ...booking, status: "cancelled" } : booking
      )
    );

    // Agregar notificación
    const notification = {
      id: Date.now(),
      type: "booking_cancelled",
      title: "Cita cancelada",
      message: "Tu cita ha sido cancelada exitosamente",
      date: new Date().toISOString(),
      read: false,
    };
    setNotifications((prev) => [notification, ...prev]);
  };

  const markNotificationAsRead = (notificationId) => {
    setNotifications((prev) => {
      const updatedNotifications = prev.map((notification) =>
        notification.id === notificationId
          ? { ...notification, read: true }
          : notification
      );
      console.log("Notifications updated:", updatedNotifications); // Log para depuración
      return updatedNotifications;
    });
  };

  const getReviewsForProfessional = (professionalId) => {
    return reviews.filter((review) => review.professionalId === professionalId);
  };

  const getUserBookings = () => {
    return bookings.filter((booking) => booking.userId === user?.id);
  };

  const getUserFavorites = () => {
    if (!user) return [];
    const userFavoriteIds = favorites
      .filter((fav) => fav.userId === user.id)
      .map((fav) => fav.professionalId);
    return professionals.filter((prof) => userFavoriteIds.includes(prof.id));
  };

  const getUserNotifications = () => {
    return notifications.filter(
      (notification) => !notification.userId || notification.userId === user?.id
    );
  };

  const getUnreadNotificationsCount = () => {
    return getUserNotifications().filter((notification) => !notification.read)
      .length;
  };

  const isProfessionalFavorite = (professionalId) => {
    if (!user) return false;
    return favorites.some(
      (fav) => fav.userId === user.id && fav.professionalId === professionalId
    );
  };

  const filteredProfessionals = professionals.filter((professional) => {
    if (filters.area && !professional.coverageAreas.includes(filters.area))
      return false;
    if (
      filters.rating &&
      professional.rating < Number.parseFloat(filters.rating)
    )
      return false;
    if (filters.search) {
      const searchTerm = filters.search.toLowerCase();
      const matchesName = professional.name.toLowerCase().includes(searchTerm);
      const matchesServices = professional.services.some((serviceId) => {
        const service = services.find((s) => s.id === serviceId);
        return service?.name.toLowerCase().includes(searchTerm);
      });
      if (!matchesName && !matchesServices) return false;
    }
    return true;
  });

  const contextValue = {
    currentView,
    setCurrentView,
    user,
    login,
    logout,
    register,
    professionals: filteredProfessionals,
    services,
    reviews,
    bookings,
    favorites,
    notifications,
    filters,
    setFilters,
    selectedProfessional,
    selectedService,
    selectedProfessionalForChat,
    handleViewProfessional,
    handleBookService,
    handleContactProfessional,
    addBooking,
    cancelBooking,
    toggleFavorite,
    markNotificationAsRead,
    getReviewsForProfessional,
    getUserBookings,
    getUserFavorites,
    getUserNotifications,
    getUnreadNotificationsCount,
    isProfessionalFavorite,
    areas: mockData.areas,
  };

  if (loading) {
    return (
      <div className="loading-container">
        <div className="loading-animation">
          <div className="beauty-loader">
            <div className="lipstick"></div>
            <div className="mirror"></div>
            <div className="brush"></div>
          </div>
          <h2>Preparando tu experiencia de belleza...</h2>
          <div className="loading-dots">
            <span></span>
            <span></span>
            <span></span>
          </div>
        </div>
      </div>
    );
  }

  return (
    <AppContext.Provider value={contextValue}>
      <div className="app">
        <Header />
        <main className="main-content">
          {currentView === "home" && <HomePage />}
          {currentView === "login" && <LoginPage />}
          {currentView === "register" && <RegisterPage />}
          {currentView === "professional" && <ProfessionalProfile />}
          {currentView === "booking" && <BookingPage />}
          {currentView === "my-bookings" && <MyBookingsPage />}
          {currentView === "profile" && <ProfilePage />}
          {currentView === "favorites" && <FavoritesPage />}
          {currentView === "notifications" && <NotificationsPage />}
          {currentView === "chat" && <ChatPage />}
        </main>
      </div>
    </AppContext.Provider>
  );
}

export default App;
