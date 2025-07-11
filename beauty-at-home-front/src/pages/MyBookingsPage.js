"use client";

import { useApp } from "../App";
import "../styles/pages/my-bookings.css";

function MyBookingsPage() {
  const { user, getUserBookings, setCurrentView, cancelBooking } = useApp();

  if (!user) {
    return (
      <div className="auth-required">
        <div className="auth-required-content">
          <div className="auth-required-icon">🔐</div>
          <h2>Inicia sesión para ver tus citas</h2>
          <p>Gestiona todas tus citas de belleza en un solo lugar</p>
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

  const userBookings = getUserBookings();
  const upcomingBookings = userBookings.filter(
    (booking) => booking.status === "confirmed"
  );
  const pastBookings = userBookings.filter(
    (booking) => booking.status === "completed"
  );
  const cancelledBookings = userBookings.filter(
    (booking) => booking.status === "cancelled"
  );

  return (
    <div className="bookings-page">
      <div className="page-container">
        <div className="page-header">
          <div className="page-header-content">
            <h1>Mis Citas</h1>
            <p>Gestiona todas tus citas de belleza</p>
          </div>
          <div className="page-stats">
            <div className="stat-item">
              <span className="stat-number">{upcomingBookings.length}</span>
              <span className="stat-label">Próximas</span>
            </div>
            <div className="stat-item">
              <span className="stat-number">{pastBookings.length}</span>
              <span className="stat-label">Completadas</span>
            </div>
          </div>
        </div>

        {userBookings.length === 0 ? (
          <div className="empty-state">
            <div className="empty-state-icon">📅</div>
            <h3>No tienes citas programadas</h3>
            <p>¡Agenda tu primera cita con nuestros profesionales!</p>
            <button
              className="empty-state-btn"
              onClick={() => setCurrentView("home")}
            >
              <span className="btn-icon">✨</span>
              Explorar Profesionales
            </button>
          </div>
        ) : (
          <div className="bookings-content">
            {upcomingBookings.length > 0 && (
              <div className="bookings-section">
                <h2 className="section-title">Próximas Citas</h2>
                <div className="bookings-grid">
                  {upcomingBookings.map((booking) => (
                    <BookingCard
                      key={booking.id}
                      booking={booking}
                      onCancel={cancelBooking}
                    />
                  ))}
                </div>
              </div>
            )}

            {pastBookings.length > 0 && (
              <div className="bookings-section">
                <h2 className="section-title">Citas Completadas</h2>
                <div className="bookings-grid">
                  {pastBookings.map((booking) => (
                    <BookingCard key={booking.id} booking={booking} />
                  ))}
                </div>
              </div>
            )}

            {cancelledBookings.length > 0 && (
              <div className="bookings-section">
                <h2 className="section-title">Citas Canceladas</h2>
                <div className="bookings-grid">
                  {cancelledBookings.map((booking) => (
                    <BookingCard key={booking.id} booking={booking} />
                  ))}
                </div>
              </div>
            )}
          </div>
        )}
      </div>
    </div>
  );
}

function BookingCard({ booking, onCancel }) {
  const getStatusColor = (status) => {
    switch (status) {
      case "confirmed":
        return "status-confirmed";
      case "completed":
        return "status-completed";
      case "cancelled":
        return "status-cancelled";
      default:
        return "status-pending";
    }
  };

  const getStatusText = (status) => {
    switch (status) {
      case "confirmed":
        return "Confirmada";
      case "completed":
        return "Completada";
      case "cancelled":
        return "Cancelada";
      default:
        return "Pendiente";
    }
  };

  const handleCancel = () => {
    if (window.confirm("¿Estás seguro de que quieres cancelar esta cita?")) {
      onCancel(booking.id);
    }
  };

  return (
    <div className="booking-card">
      <div className="booking-header">
        <div className="booking-date">
          <span className="date">
            {new Date(booking.date).toLocaleDateString()}
          </span>
          <span className="time">{booking.time}</span>
        </div>
        <span className={`booking-status ${getStatusColor(booking.status)}`}>
          {getStatusText(booking.status)}
        </span>
      </div>

      <div className="booking-details">
        <h3 className="service-name">{booking.serviceName}</h3>
        <p className="professional-name">Con {booking.professionalName}</p>
        <p className="booking-address">📍 {booking.address}</p>

        <div className="booking-meta">
          <span className="price">
            ${booking.servicePrice.toLocaleString()}
          </span>
          <span className="duration">⏱️ {booking.serviceDuration} min</span>
        </div>

        {booking.notes && (
          <div className="booking-notes">
            <strong>Notas:</strong> {booking.notes}
          </div>
        )}
      </div>

      <div className="booking-actions">
        {booking.status === "confirmed" && (
          <>
            <button className="action-btn secondary">
              <span className="btn-icon">📅</span>
              Reagendar
            </button>
            <button className="action-btn danger" onClick={handleCancel}>
              <span className="btn-icon">❌</span>
              Cancelar
            </button>
          </>
        )}
        {booking.status === "completed" && (
          <button className="action-btn primary">
            <span className="btn-icon">⭐</span>
            Dejar Reseña
          </button>
        )}
      </div>
    </div>
  );
}

export default MyBookingsPage;
