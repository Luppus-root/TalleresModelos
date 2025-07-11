"use client";

import { useApp } from "../App";
import "../styles/components/hero-section.css";

function HeroSection() {
  const { setCurrentView, user } = useApp();

  return (
    <section className="hero-section">
      <div className="hero-content">
        <div className="hero-text">
          <h1 className="hero-title">Belleza profesional en tu hogar</h1>
          <p className="hero-subtitle">
            Conectamos con los mejores especialistas de belleza para brindarte
            servicios de calidad en la comodidad de tu casa
          </p>
          <div className="hero-buttons">
            <button
              className="cta-button primary"
              onClick={() => setCurrentView("home")}
            >
              <span>Explorar Profesionales</span>
            </button>
            {!user && (
              <button
                className="cta-button secondary"
                onClick={() => setCurrentView("register")}
              >
                <span>Únete Gratis</span>
              </button>
            )}
          </div>
        </div>

        <div className="hero-visual">
          <div className="floating-elements">
            <div className="floating-card card-1">
              <span className="card-icon">💅</span>
              <span className="card-text">Manicure</span>
            </div>
            <div className="floating-card card-2">
              <span className="card-icon">✂️</span>
              <span className="card-text">Corte</span>
            </div>
            <div className="floating-card card-3">
              <span className="card-icon">💄</span>
              <span className="card-text">Maquillaje</span>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}

export default HeroSection;
