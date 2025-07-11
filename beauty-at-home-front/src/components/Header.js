"use client";

import { useApp } from "../App";
import "../styles/components/header.css";

function Header() {
  const {
    currentView,
    setCurrentView,
    user,
    logout,
    getUnreadNotificationsCount,
  } = useApp();
  const unreadCount = getUnreadNotificationsCount();

  return (
    <header className="header">
      <div className="header-content">
        <div className="logo" onClick={() => setCurrentView("home")}>
          <div className="logo-icon">
            <span className="icon-beauty">💄</span>
            <div className="logo-sparkles">
              <span>✨</span>
              <span>✨</span>
              <span>✨</span>
            </div>
          </div>
          <div className="logo-text">
            <h1>BeautyAtHome</h1>
            <p>Tu belleza, nuestra pasión</p>
          </div>
        </div>

        <nav className="nav">
          <button
            className={`nav-button ${currentView === "home" ? "active" : ""}`}
            onClick={() => setCurrentView("home")}
          >
            <span className="nav-icon">🏠</span>
            Inicio
          </button>

          {user && (
            <>
              <button
                className={`nav-button ${
                  currentView === "my-bookings" ? "active" : ""
                }`}
                onClick={() => setCurrentView("my-bookings")}
              >
                <span className="nav-icon">📅</span>
                Mis Citas
              </button>
              <button
                className={`nav-button ${
                  currentView === "favorites" ? "active" : ""
                }`}
                onClick={() => setCurrentView("favorites")}
              >
                <span className="nav-icon">❤️</span>
                Favoritos
              </button>
              <button
                className={`nav-button ${
                  currentView === "profile" ? "active" : ""
                }`}
                onClick={() => setCurrentView("profile")}
              >
                <span className="nav-icon">👤</span>
                Perfil
              </button>
            </>
          )}
        </nav>

        <div className="header-actions">
          {user ? (
            <div className="user-menu">
              <button
                className={`notification-btn ${
                  currentView === "notifications" ? "active" : ""
                }`}
                onClick={() => setCurrentView("notifications")}
              >
                <span className="notification-icon">🔔</span>
                {unreadCount > 0 && (
                  <span className="notification-badge">{unreadCount}</span>
                )}
              </button>
              <div className="user-info">
                <img
                  src={user.avatar || "/placeholder.svg"}
                  alt={user.name}
                  className="user-avatar"
                />
                <div className="user-details">
                  <span className="user-name">¡Hola, {user.name}!</span>
                  <span className="user-role">Cliente</span>
                </div>
              </div>
              <button className="logout-btn" onClick={logout}>
                <span className="logout-icon">🚪</span>
                Salir
              </button>
            </div>
          ) : (
            <div className="auth-buttons">
              <button
                className={`auth-btn ${
                  currentView === "login" ? "active" : ""
                }`}
                onClick={() => setCurrentView("login")}
              >
                Iniciar Sesión
              </button>
              <button
                className={`auth-btn primary ${
                  currentView === "register" ? "active" : ""
                }`}
                onClick={() => setCurrentView("register")}
              >
                Registrarse
              </button>
            </div>
          )}
        </div>
      </div>
    </header>
  );
}

export default Header;
