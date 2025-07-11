"use client";

import { useApp } from "../App";
import "../styles/pages/notifications.css";

function NotificationsPage() {
  const { user, getUserNotifications, markNotificationAsRead, setCurrentView } =
    useApp();

  if (!user) {
    return (
      <div className="auth-required">
        <div className="auth-required-content">
          <div className="auth-required-icon">🔐</div>
          <h2>Inicia sesión para ver tus notificaciones</h2>
          <p>Mantente al día con todas tus citas y actualizaciones</p>
          <button
            className="auth-required-btn"
            onClick={() => setCurrentView("login")}
          >
            Iniciar Sesión
          </button>
        </div>
      </div>
    );
  }

  const notifications = getUserNotifications();

  const handleNotificationClick = (notification) => {
    if (!notification.read) {
      markNotificationAsRead(notification.id);
    }
  };

  const getNotificationIcon = (type) => {
    switch (type) {
      case "booking_confirmed":
        return "✅";
      case "booking_cancelled":
        return "❌";
      case "booking_reminder":
        return "⏰";
      case "new_review":
        return "⭐";
      case "promotion":
        return "🎉";
      default:
        return "📢";
    }
  };

  const getNotificationColor = (type) => {
    switch (type) {
      case "booking_confirmed":
        return "notification-success";
      case "booking_cancelled":
        return "notification-danger";
      case "booking_reminder":
        return "notification-warning";
      case "new_review":
        return "notification-info";
      case "promotion":
        return "notification-primary";
      default:
        return "notification-default";
    }
  };

  return (
    <div className="notifications-page">
      <div className="page-container">
        <div className="page-header">
          <div className="page-header-content">
            <h1>Notificaciones</h1>
            <p>Mantente al día con todas tus actualizaciones</p>
          </div>
          <div className="page-stats">
            <div className="stat-item">
              <span className="stat-number">
                {notifications.filter((n) => !n.read).length}
              </span>
              <span className="stat-label">Sin leer</span>
            </div>
          </div>
        </div>

        {notifications.length === 0 ? (
          <div className="empty-state">
            <div className="empty-state-icon">🔔</div>
            <h3>No tienes notificaciones</h3>
            <p>
              Cuando tengas citas o actualizaciones importantes, aparecerán aquí
            </p>
            <button
              className="empty-state-btn"
              onClick={() => setCurrentView("home")}
            >
              <span className="btn-icon">🏠</span>
              Ir al Inicio
            </button>
          </div>
        ) : (
          <div className="notifications-list">
            {notifications.map((notification) => (
              <div
                key={notification.id}
                className={`notification-card ${
                  !notification.read ? "unread" : ""
                } ${getNotificationColor(notification.type)}`}
                onClick={() => handleNotificationClick(notification)}
              >
                <div className="notification-icon">
                  {getNotificationIcon(notification.type)}
                </div>
                <div className="notification-content">
                  <h3 className="notification-title">{notification.title}</h3>
                  <p className="notification-message">{notification.message}</p>
                  <span className="notification-date">
                    {new Date(notification.date).toLocaleDateString()} -{" "}
                    {new Date(notification.date).toLocaleTimeString()}
                  </span>
                </div>
                {!notification.read && <div className="notification-dot"></div>}
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
}

export default NotificationsPage;
