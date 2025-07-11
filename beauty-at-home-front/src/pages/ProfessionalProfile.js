"use client";

import { useState } from "react";
import { useApp } from "../App";
import StarRating from "../components/StarRating";
import ServiceCard from "../components/ServiceCard";
import ReviewCard from "../components/ReviewCard";

function ProfessionalProfile() {
  const {
    selectedProfessional,
    services,
    getReviewsForProfessional,
    setCurrentView,
    toggleFavorite,
    isProfessionalFavorite,
  } = useApp();
  const [activeTab, setActiveTab] = useState("services");

  if (!selectedProfessional) {
    return (
      <div className="profile-error">
        <div className="error-content">
          <div className="error-icon">😕</div>
          <h2>Profesional no encontrado</h2>
          <p>No pudimos encontrar la información de este profesional</p>
          <button className="error-btn" onClick={() => setCurrentView("home")}>
            <span className="btn-icon">🏠</span>
            Volver al inicio
          </button>
        </div>
      </div>
    );
  }

  const professionalServices = services.filter((service) =>
    selectedProfessional.services.includes(service.id)
  );
  const reviews = getReviewsForProfessional(selectedProfessional.id);
  const isFavorite = isProfessionalFavorite(selectedProfessional.id);

  const handleFavoriteClick = () => {
    toggleFavorite(selectedProfessional.id);
  };

  return (
    <div className="professional-profile">
      <button className="back-button" onClick={() => setCurrentView("home")}>
        <span className="back-icon">←</span>
        <span>Volver a profesionales</span>
      </button>

      <div className="profile-hero">
        <div className="profile-content">
          <div className="profile-photo-section">
            <div className="photo-container">
              <img
                src={selectedProfessional.photo || "/placeholder.svg"}
                alt={selectedProfessional.name}
              />
              <div className="status-indicator online"></div>
            </div>

            {selectedProfessional.isSponsored && (
              <div className="sponsor-badge">
                <div className="sponsor-icon">👑</div>
                <div className="sponsor-info">
                  <span className="sponsor-label">Patrocinado por</span>
                  <span className="sponsor-brand">
                    {selectedProfessional.sponsorBrand}
                  </span>
                </div>
              </div>
            )}
          </div>

          <div className="profile-info">
            <h1>{selectedProfessional.name}</h1>

            <div className="profile-rating">
              <StarRating rating={selectedProfessional.rating} size="large" />
              <div className="rating-details">
                <span className="rating-number">
                  {selectedProfessional.rating}
                </span>
                <span className="rating-count">
                  ({selectedProfessional.totalReviews} reseñas)
                </span>
              </div>
            </div>

            <p className="profile-experience">
              {selectedProfessional.experience}
            </p>

            <div className="profile-coverage">
              <h4>Áreas de cobertura:</h4>
              <div className="coverage-tags">
                {selectedProfessional.coverageAreas.map((area) => (
                  <span key={area} className="coverage-tag">
                    📍 {area}
                  </span>
                ))}
              </div>
            </div>

            <div className="profile-actions">
              <button className="action-btn primary large">
                <span className="btn-icon">💬</span>
                <span>Contactar</span>
              </button>
              <button
                className={`action-btn ${isFavorite ? "danger" : "tertiary"}`}
                onClick={handleFavoriteClick}
              >
                <span className="btn-icon">{isFavorite ? "❤️" : "🤍"}</span>
                <span>{isFavorite ? "Quitar" : "Favorito"}</span>
              </button>
            </div>
          </div>
        </div>
      </div>

      <div className="profile-tabs">
        <div className="tabs-container">
          <button
            className={`tab-button ${activeTab === "services" ? "active" : ""}`}
            onClick={() => setActiveTab("services")}
          >
            <span className="tab-icon">✨</span>
            <span>Servicios ({professionalServices.length})</span>
          </button>
          <button
            className={`tab-button ${activeTab === "reviews" ? "active" : ""}`}
            onClick={() => setActiveTab("reviews")}
          >
            <span className="tab-icon">⭐</span>
            <span>Reseñas ({reviews.length})</span>
          </button>
        </div>
      </div>

      <div className="tab-content">
        {activeTab === "services" && (
          <ServicesTab services={professionalServices} />
        )}
        {activeTab === "reviews" && <ReviewsTab reviews={reviews} />}
      </div>
    </div>
  );
}

function ServicesTab({ services }) {
  return (
    <div className="services-tab">
      <div className="services-grid">
        {services.map((service, index) => (
          <ServiceCard key={service.id} service={service} index={index} />
        ))}
      </div>
    </div>
  );
}

function ReviewsTab({ reviews }) {
  const { services } = useApp();

  return (
    <div className="reviews-tab">
      {reviews.length === 0 ? (
        <div className="no-reviews">
          <div className="no-reviews-icon">⭐</div>
          <h3>Aún no hay reseñas</h3>
          <p>Sé el primero en dejar una reseña</p>
        </div>
      ) : (
        <div className="reviews-grid">
          {reviews.map((review, index) => (
            <ReviewCard
              key={review.id}
              review={review}
              services={services}
              index={index}
            />
          ))}
        </div>
      )}
    </div>
  );
}

export default ProfessionalProfile;
