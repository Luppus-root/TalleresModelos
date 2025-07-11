"use client";

import { useState, useEffect } from "react";
import { useApp } from "../App";
import StarRating from "../components/StarRating";
import "../styles/pages/review-form.css";
import "../styles/pages/auth.css";
import "../styles/components/star-rating.css";

function ReviewFormPage() {
  const {
    user,
    bookingToReview,
    addReview,
    setCurrentView,
    professionals,
    services,
  } = useApp();
  const [rating, setRating] = useState(0);
  const [comment, setComment] = useState("");
  const [errors, setErrors] = useState({});
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    if (!bookingToReview) {
      setCurrentView("my-bookings"); // Redirigir si no hay reserva seleccionada
    }
  }, [bookingToReview, setCurrentView]);

  // Agregamos un console.log para verificar el estado de la calificación
  useEffect(() => {
    console.log("Current rating in ReviewFormPage:", rating);
  }, [rating]);

  if (!user) {
    return (
      <div className="auth-required">
        <div className="auth-required-content">
          <div className="auth-required-icon">🔐</div>
          <h2>Inicia sesión para dejar una reseña</h2>
          <p>Necesitas estar logueado para compartir tu experiencia.</p>
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

  if (!bookingToReview) {
    return null; // O un spinner/mensaje de carga mientras se redirige
  }

  const professional = professionals.find(
    (p) => p.id === bookingToReview.professionalId
  );
  const service = services.find((s) => s.id === bookingToReview.serviceId);

  const validateForm = () => {
    const newErrors = {};
    if (rating === 0) {
      newErrors.rating = "Por favor, selecciona una calificación.";
    }
    if (comment.trim().length < 10) {
      newErrors.comment = "Tu comentario debe tener al menos 10 caracteres.";
    }
    return newErrors;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const newErrors = validateForm();

    if (Object.keys(newErrors).length > 0) {
      setErrors(newErrors);
      return;
    }

    setIsLoading(true);

    const reviewData = {
      bookingId: bookingToReview.id,
      professionalId: professional.id,
      serviceId: service.id,
      rating,
      comment,
      userId: user.id,
      professionalName: professional.name, // Añadir para la notificación
    };

    setTimeout(() => {
      addReview(reviewData);
      setIsLoading(false);
    }, 1000);
  };

  return (
    <div className="review-form-page">
      <div className="page-container">
        <button
          className="back-button"
          onClick={() => setCurrentView("my-bookings")}
        >
          <span className="back-icon">←</span>
          <span>Volver a Mis Citas</span>
        </button>

        <div className="review-form-card">
          <div className="review-form-header">
            <div className="review-icon">⭐</div>
            <h1>Deja tu Reseña</h1>
            <p>
              Comparte tu experiencia con {professional?.name} por el servicio
              de {service?.name}.
            </p>
          </div>

          <form className="review-form" onSubmit={handleSubmit}>
            <div className="form-group">
              <label htmlFor="rating">Calificación</label>
              <div className="rating-input-container">
                <StarRating
                  rating={rating}
                  size="large"
                  interactive={true}
                  onRatingChange={setRating}
                />
              </div>
              {errors.rating && (
                <span className="error-message">{errors.rating}</span>
              )}
            </div>

            <div className="form-group">
              <label htmlFor="comment">Tu Comentario</label>
              <div className="input-container">
                <textarea
                  id="comment"
                  name="comment"
                  value={comment}
                  onChange={(e) => {
                    setComment(e.target.value);
                    if (errors.comment)
                      setErrors((prev) => ({ ...prev, comment: "" }));
                  }}
                  placeholder="Describe tu experiencia..."
                  rows="6"
                  className={errors.comment ? "error" : ""}
                />
              </div>
              {errors.comment && (
                <span className="error-message">{errors.comment}</span>
              )}
            </div>

            <button
              type="submit"
              className="submit-review-btn"
              disabled={isLoading}
            >
              {isLoading ? (
                <>
                  <div className="spinner"></div>
                  Enviando reseña...
                </>
              ) : (
                <>
                  <span className="btn-icon">🚀</span>
                  Enviar Reseña
                </>
              )}
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}

export default ReviewFormPage;
