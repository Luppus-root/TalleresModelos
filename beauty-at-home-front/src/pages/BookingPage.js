"use client";

import { useState } from "react";
import { useApp } from "../App";
import "../styles/pages/booking.css";
import "../styles/pages/auth.css";

function BookingPage() {
  const {
    selectedProfessional,
    selectedService,
    user,
    addBooking,
    setCurrentView,
  } = useApp();
  const [bookingData, setBookingData] = useState({
    date: "",
    time: "",
    address: "",
    notes: "",
  });
  const [errors, setErrors] = useState({});
  const [isLoading, setIsLoading] = useState(false);

  const timeSlots = [
    "09:00",
    "10:00",
    "11:00",
    "12:00",
    "14:00",
    "15:00",
    "16:00",
    "17:00",
    "18:00",
  ];

  const handleChange = (e) => {
    const { name, value } = e.target;
    setBookingData((prev) => ({
      ...prev,
      [name]: value,
    }));
    if (errors[name]) {
      setErrors((prev) => ({
        ...prev,
        [name]: "",
      }));
    }
  };

  const validateForm = () => {
    const newErrors = {};

    if (!bookingData.date) {
      newErrors.date = "Selecciona una fecha";
    }

    if (!bookingData.time) {
      newErrors.time = "Selecciona una hora";
    }

    if (!bookingData.address) {
      newErrors.address = "La dirección es requerida";
    }

    return newErrors;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!user) {
      setCurrentView("login");
      return;
    }

    const newErrors = validateForm();

    if (Object.keys(newErrors).length > 0) {
      setErrors(newErrors);
      return;
    }

    setIsLoading(true);

    setTimeout(() => {
      const booking = {
        userId: user.id,
        professionalId: selectedProfessional.id,
        serviceId: selectedService.id,
        professionalName: selectedProfessional.name,
        serviceName: selectedService.name,
        servicePrice: selectedService.price,
        serviceDuration: selectedService.duration,
        ...bookingData,
      };

      addBooking(booking);
      setIsLoading(false);
    }, 1000);
  };

  if (!selectedProfessional || !selectedService) {
    return (
      <div className="booking-page">
        <div className="booking-error">
          <h2>Error</h2>
          <p>No se encontró información del servicio</p>
          <button onClick={() => setCurrentView("home")}>
            Volver al inicio
          </button>
        </div>
      </div>
    );
  }

  return (
    <div className="booking-page">
      <div className="booking-container">
        <button
          className="back-button"
          onClick={() => setCurrentView("professional")}
        >
          <span className="back-icon">←</span>
          Volver al perfil
        </button>

        <div className="booking-content">
          <div className="booking-summary">
            <h2>Resumen de tu cita</h2>

            <div className="summary-card">
              <div className="professional-info">
                <img
                  src={selectedProfessional.photo || "/placeholder.svg"}
                  alt={selectedProfessional.name}
                />
                <div>
                  <h3>{selectedProfessional.name}</h3>
                  <div className="rating">
                    <span>⭐ {selectedProfessional.rating}</span>
                    <span>({selectedProfessional.totalReviews} reseñas)</span>
                  </div>
                </div>
              </div>

              <div className="service-info">
                <h4>{selectedService.name}</h4>
                <p>{selectedService.description}</p>
                <div className="service-details">
                  <span className="price">
                    ${selectedService.price.toLocaleString()}
                  </span>
                  <span className="duration">
                    ⏱️ {selectedService.duration} min
                  </span>
                </div>
              </div>
            </div>
          </div>

          <div className="booking-form-container">
            <h2>Agenda tu cita</h2>

            <form className="booking-form" onSubmit={handleSubmit}>
              <div className="form-row">
                <div className="form-group">
                  <label htmlFor="date">Fecha</label>
                  <div className="input-container">
                    <input
                      type="date"
                      id="date"
                      name="date"
                      value={bookingData.date}
                      onChange={handleChange}
                      min={new Date().toISOString().split("T")[0]}
                      className={errors.date ? "error" : ""}
                    />
                  </div>
                  {errors.date && (
                    <span className="error-message">{errors.date}</span>
                  )}
                </div>

                <div className="form-group">
                  <label htmlFor="time">Hora</label>
                  <div className="input-container">
                    <select
                      id="time"
                      name="time"
                      value={bookingData.time}
                      onChange={handleChange}
                      className={errors.time ? "error" : ""}
                    >
                      <option value="">Selecciona una hora</option>
                      {timeSlots.map((time) => (
                        <option key={time} value={time}>
                          {time}
                        </option>
                      ))}
                    </select>
                  </div>
                  {errors.time && (
                    <span className="error-message">{errors.time}</span>
                  )}
                </div>
              </div>

              <div className="form-group">
                <label htmlFor="address">Dirección</label>
                <div className="input-container">
                  <input
                    type="text"
                    id="address"
                    name="address"
                    value={bookingData.address}
                    onChange={handleChange}
                    placeholder="Dirección completa donde se realizará el servicio"
                    className={errors.address ? "error" : ""}
                  />
                </div>
                {errors.address && (
                  <span className="error-message">{errors.address}</span>
                )}
              </div>

              <div className="form-group">
                <label htmlFor="notes">Notas adicionales (opcional)</label>
                <div className="input-container">
                  <textarea
                    id="notes"
                    name="notes"
                    value={bookingData.notes}
                    onChange={handleChange}
                    placeholder="Cualquier información adicional que quieras compartir..."
                    rows="4"
                  />
                </div>
              </div>

              <button
                type="submit"
                className="booking-submit-btn"
                disabled={isLoading}
              >
                {isLoading ? (
                  <>
                    <div className="spinner"></div>
                    Confirmando cita...
                  </>
                ) : (
                  <>
                    <span className="btn-icon">📅</span>
                    Confirmar Cita
                  </>
                )}
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default BookingPage;
