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
import ReviewFormPage from "./pages/ReviewFormPage";
import { mockData } from "./data/mockData";

import "./styles/base.css";

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
  const [bookingToReview, setBookingToReview] = useState(null);
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
    setTimeout(() => {
      setProfessionals(mockData.professionals);
      setServices(mockData.services);
      setReviews(mockData.reviews);
      setBookings(mockData.bookings);
      setFavorites(mockData.favorites);
      setNotifications(mockData.notifications);

      const savedUser = localStorage.getItem("beautyAtHomeUser");
      if (savedUser) {
        setUser(JSON.parse(savedUser));
      }

      setLoading(false);
    }, 1500);
  }, []);

  const login = (userData) => {
    const updatedUserData = {
      ...userData,
      avatar: "/assets/profile-photos/maria-garcia.jpeg", // Ruta específica para María García
    };
    setUser(updatedUserData);
    localStorage.setItem("beautyAtHomeUser", JSON.stringify(updatedUserData));
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
      avatar: "/assets/profile-photos/maria-garcia.jpeg",
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
      reviewed: false, // Inicializar como no reseñada
    };
    setBookings((prev) => [...prev, newBooking]);

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
      console.log("Notifications updated:", updatedNotifications);
      return updatedNotifications;
    });
  };

  const addReview = (reviewData) => {
    const newReview = {
      id: Date.now(),
      ...reviewData,
      date: new Date().toISOString().split("T")[0],
      clientInitials: user?.name
        ? user.name
            .split(" ")
            .map((n) => n[0])
            .join(".")
        : "Anónimo",
      servicePhotos: [],
    };
    setReviews((prev) => [...prev, newReview]);

    // Marcar la reserva como reseñada
    setBookings((prev) =>
      prev.map((booking) =>
        booking.id === reviewData.bookingId
          ? { ...booking, reviewed: true }
          : booking
      )
    );

    const notification = {
      id: Date.now() + 1,
      type: "new_review",
      title: "¡Gracias por tu reseña!",
      message: `Tu reseña para ${reviewData.professionalName} ha sido publicada.`,
      date: new Date().toISOString(),
      read: false,
    };
    setNotifications((prev) => [notification, ...prev]);

    setCurrentView("my-bookings");
    setBookingToReview(null);
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

  const getUserReviews = () => {
    if (!user) return [];
    return reviews.filter((review) => review.userId === user.id);
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
    bookingToReview,
    setBookingToReview,
    handleViewProfessional,
    handleBookService,
    handleContactProfessional,
    addBooking,
    cancelBooking,
    toggleFavorite,
    markNotificationAsRead,
    addReview,
    getReviewsForProfessional,
    getUserBookings,
    getUserFavorites,
    getUserReviews, // Añadido
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
          {currentView === "review-form" && <ReviewFormPage />}
        </main>
      </div>
    </AppContext.Provider>
  );
}

export default App;
