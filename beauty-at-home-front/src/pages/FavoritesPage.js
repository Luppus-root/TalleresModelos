"use client";

import { useApp } from "../App";
import ProfessionalCard from "../components/ProfessionalCard";
import "../styles/pages/favorites.css";
import "../styles/components/professional-card.css"; // Necesario para ProfessionalCard

function FavoritesPage() {
  const { user, getUserFavorites, handleViewProfessional, setCurrentView } =
    useApp();

  if (!user) {
    return (
      <div className="auth-required">
        <div className="auth-required-content">
          <div className="auth-required-icon">🔐</div>
          <h2>Inicia sesión para ver tus favoritos</h2>
          <p>Guarda tus profesionales favoritos para encontrarlos fácilmente</p>
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

  const favoriteProfessionals = getUserFavorites();

  return (
    <div className="favorites-page">
      <div className="page-container">
        <div className="page-header">
          <div className="page-header-content">
            <h1>Mis Favoritos</h1>
            <p>Tus profesionales de belleza favoritos</p>
          </div>
          <div className="page-stats">
            <div className="stat-item">
              <span className="stat-number">
                {favoriteProfessionals.length}
              </span>
              <span className="stat-label">Favoritos</span>
            </div>
          </div>
        </div>

        {favoriteProfessionals.length === 0 ? (
          <div className="empty-state">
            <div className="empty-state-icon">❤️</div>
            <h3>No tienes favoritos aún</h3>
            <p>
              Explora nuestros profesionales y guarda tus favoritos para
              encontrarlos fácilmente
            </p>
            <button
              className="empty-state-btn"
              onClick={() => setCurrentView("home")}
            >
              <span className="btn-icon">🔍</span>
              Explorar Profesionales
            </button>
          </div>
        ) : (
          <div className="favorites-grid">
            {favoriteProfessionals.map((professional, index) => (
              <ProfessionalCard
                key={professional.id}
                professional={professional}
                onView={() => handleViewProfessional(professional)}
                index={index}
              />
            ))}
          </div>
        )}
      </div>
    </div>
  );
}

export default FavoritesPage;
