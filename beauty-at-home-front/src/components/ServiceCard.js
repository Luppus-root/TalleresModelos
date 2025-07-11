"use client";

import { useState } from "react";
import { useApp } from "../App";
import "../styles/components/service-card.css";

function ServiceCard({ service, index }) {
  const [isHovered, setIsHovered] = useState(false);
  const { selectedProfessional, handleBookService, user, setCurrentView } =
    useApp();

  const handleBookClick = () => {
    if (!user) {
      setCurrentView("login");
      return;
    }
    handleBookService(selectedProfessional, service);
  };

  return (
    <div
      className={`service-card ${isHovered ? "hovered" : ""}`}
      onMouseEnter={() => setIsHovered(true)}
      onMouseLeave={() => setIsHovered(false)}
      style={{ animationDelay: `${index * 0.1}s` }}
    >
      <div className="service-images">
        {service.images.map((image, imgIndex) => (
          <div key={imgIndex} className="service-image-container">
            <img src={image || "/placeholder.svg"} alt={service.name} />
            <div className="image-overlay">
              <button className="zoom-btn">🔍</button>
            </div>
          </div>
        ))}
      </div>

      <div className="service-content">
        <h3 className="service-name">{service.name}</h3>
        <p className="service-description">{service.description}</p>

        <div className="service-meta">
          <div className="price-container">
            <span className="price-label">Precio</span>
            <span className="price">${service.price.toLocaleString()}</span>
          </div>
          <div className="duration-container">
            <span className="duration-icon">⏱️</span>
            <span className="duration">{service.duration} min</span>
          </div>
        </div>

        <div className="service-actions">
          <button className="service-btn primary" onClick={handleBookClick}>
            <span className="btn-icon">📅</span>
            <span>Agendar</span>
          </button>
          <button className="service-btn secondary">
            <span className="btn-icon">ℹ️</span>
            <span>Más info</span>
          </button>
        </div>
      </div>
    </div>
  );
}

export default ServiceCard;
