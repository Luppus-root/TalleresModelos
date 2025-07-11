"use client";

import { useState } from "react";
import StarRating from "./StarRating";
import { useApp } from "../App";
import "../styles/components/professional-card.css";
import "../styles/components/star-rating.css";

function ProfessionalCard({ professional, onView, index }) {
  const [isHovered, setIsHovered] = useState(false);
  const { toggleFavorite, isProfessionalFavorite, handleContactProfessional } =
    useApp();
  const isFavorite = isProfessionalFavorite(professional.id);

  const handleFavoriteClick = (e) => {
    e.stopPropagation();
    toggleFavorite(professional.id);
  };

  const handleContactClick = (e) => {
    e.stopPropagation();
    handleContactProfessional(professional);
  };

  return (
    <div
      className={`professional-card ${isHovered ? "hovered" : ""}`}
      onMouseEnter={() => setIsHovered(true)}
      onMouseLeave={() => setIsHovered(false)}
      style={{ animationDelay: `${index * 0.1}s` }}
    >
      {professional.isSponsored && (
        <div className="sponsored-badge">
          <span className="badge-icon">👑</span>
          <span className="badge-text">Patrocinado</span>
          <div className="badge-brand">{professional.sponsorBrand}</div>
        </div>
      )}

      <button
        className={`favorite-btn ${isFavorite ? "active" : ""}`}
        onClick={handleFavoriteClick}
        title={isFavorite ? "Quitar de favoritos" : "Agregar a favoritos"}
      >
        <span className="favorite-icon">{isFavorite ? "❤️" : "🤍"}</span>
      </button>

      <div className="card-header">
        <div className="professional-photo-container">
          <img
            src={professional.photo || "/placeholder.svg"}
            alt={professional.name}
            className="professional-photo"
          />
          <div className="photo-overlay">
            <button className="quick-view-btn" onClick={onView}>
              👁️ Ver perfil
            </button>
          </div>
        </div>

        <div className="professional-status">
          <div className="status-indicator online"></div>
          <span>Disponible</span>
        </div>
      </div>

      <div className="card-content">
        <h3 className="professional-name">{professional.name}</h3>

        <div className="rating-container">
          <StarRating rating={professional.rating} />
          <span className="rating-text">
            {professional.rating} ({professional.totalReviews} reseñas)
          </span>
        </div>

        <p className="experience-preview">{professional.experience}</p>

        <div className="services-preview">
          <span className="services-label">Especialidades:</span>
          <div className="services-tags">
            {professional.services.slice(0, 2).map((serviceId) => (
              <span key={serviceId} className="service-tag">
                {getServiceName(serviceId)}
              </span>
            ))}
            {professional.services.length > 2 && (
              <span className="more-services">
                +{professional.services.length - 2}
              </span>
            )}
          </div>
        </div>

        <div className="coverage-preview">
          <span className="coverage-icon">📍</span>
          <span className="coverage-text">{professional.coverageAreas[0]}</span>
          {professional.coverageAreas.length > 1 && (
            <span className="more-areas">
              +{professional.coverageAreas.length - 1}
            </span>
          )}
        </div>
      </div>

      <div className="card-actions">
        <button className="action-btn secondary" onClick={handleContactClick}>
          <span className="btn-icon">💬</span>
          Contactar
        </button>
        <button className="action-btn primary" onClick={onView}>
          <span className="btn-icon">👁️</span>
          Ver perfil
        </button>
      </div>
    </div>
  );
}

function getServiceName(serviceId) {
  const serviceNames = {
    1: "Corte",
    2: "Color",
    3: "Tratamiento",
    4: "Corte Masculino",
    5: "Barba",
    6: "Manicure",
    7: "Pedicure",
    8: "Nail Art",
    9: "Maquillaje",
    10: "Maquillaje Novia",
  };
  return serviceNames[serviceId] || "Servicio";
}

export default ProfessionalCard;
