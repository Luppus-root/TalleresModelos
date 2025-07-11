"use client";

import { useState } from "react";
import { useApp } from "../App";
import "../styles/pages/profile.css";
import "../styles/pages/auth.css";

function ProfilePage() {
  const { user, setCurrentView, getUserBookings, getUserFavorites } = useApp();
  const [isEditing, setIsEditing] = useState(false);
  const [formData, setFormData] = useState({
    name: user?.name || "",
    email: user?.email || "",
    phone: user?.phone || "",
  });

  if (!user) {
    return (
      <div className="auth-required">
        <div className="auth-required-content">
          <div className="auth-required-icon">🔐</div>
          <h2>Inicia sesión para ver tu perfil</h2>
          <p>Accede a tu información personal y preferencias</p>
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
  const userFavorites = getUserFavorites();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSave = () => {
    // Aquí se actualizaría la información del usuario
    setIsEditing(false);
  };

  return (
    <div className="profile-page">
      <div className="page-container">
        <div className="profile-header">
          <div className="profile-avatar-section">
            <div className="profile-avatar">
              <img src={user.avatar || "/placeholder.svg"} alt={user.name} />
              <button className="avatar-edit-btn">
                <span className="btn-icon">📷</span>
              </button>
            </div>
            <div className="profile-info">
              <h1 className="profile-name">{user.name}</h1>
              <p className="profile-member-since">
                Miembro desde {new Date(user.joinDate).toLocaleDateString()}
              </p>
              <div className="profile-stats">
                <div className="stat-item">
                  <span className="stat-number">{userBookings.length}</span>
                  <span className="stat-label">Citas</span>
                </div>
                <div className="stat-item">
                  <span className="stat-number">{userFavorites.length}</span>
                  <span className="stat-label">Favoritos</span>
                </div>
                <div className="stat-item">
                  <span className="stat-number">4.8</span>
                  <span className="stat-label">Rating</span>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div className="profile-content">
          <div className="profile-section">
            <div className="section-header">
              <h2>Información Personal</h2>
              <button
                className="edit-btn"
                onClick={() => setIsEditing(!isEditing)}
              >
                <span className="btn-icon">{isEditing ? "❌" : "✏️"}</span>
                {isEditing ? "Cancelar" : "Editar"}
              </button>
            </div>

            <div className="profile-form">
              <div className="form-row">
                <div className="form-group">
                  <label>Nombre Completo</label>
                  {isEditing ? (
                    <input
                      type="text"
                      name="name"
                      value={formData.name}
                      onChange={handleChange}
                      className="form-input"
                    />
                  ) : (
                    <p className="form-value">{user.name}</p>
                  )}
                </div>

                <div className="form-group">
                  <label>Email</label>
                  {isEditing ? (
                    <input
                      type="email"
                      name="email"
                      value={formData.email}
                      onChange={handleChange}
                      className="form-input"
                    />
                  ) : (
                    <p className="form-value">{user.email}</p>
                  )}
                </div>
              </div>

              <div className="form-group">
                <label>Teléfono</label>
                {isEditing ? (
                  <input
                    type="tel"
                    name="phone"
                    value={formData.phone}
                    onChange={handleChange}
                    className="form-input"
                  />
                ) : (
                  <p className="form-value">{user.phone}</p>
                )}
              </div>

              {isEditing && (
                <button className="save-btn" onClick={handleSave}>
                  <span className="btn-icon">💾</span>
                  Guardar Cambios
                </button>
              )}
            </div>
          </div>

          <div className="profile-section">
            <h2>Preferencias</h2>
            <div className="preferences">
              <div className="preference-item">
                <div className="preference-info">
                  <span className="preference-title">
                    Notificaciones por email
                  </span>
                  <span className="preference-description">
                    Recibe confirmaciones y recordatorios
                  </span>
                </div>
                <label className="toggle-switch">
                  <input type="checkbox" defaultChecked />
                  <span className="toggle-slider"></span>
                </label>
              </div>
              <div className="preference-item">
                <div className="preference-info">
                  <span className="preference-title">Notificaciones push</span>
                  <span className="preference-description">
                    Alertas en tiempo real
                  </span>
                </div>
                <label className="toggle-switch">
                  <input type="checkbox" defaultChecked />
                  <span className="toggle-slider"></span>
                </label>
              </div>
              <div className="preference-item">
                <div className="preference-info">
                  <span className="preference-title">
                    Ofertas y promociones
                  </span>
                  <span className="preference-description">
                    Descuentos especiales y novedades
                  </span>
                </div>
                <label className="toggle-switch">
                  <input type="checkbox" />
                  <span className="toggle-slider"></span>
                </label>
              </div>
            </div>
          </div>

          <div className="profile-section">
            <h2>Acciones de Cuenta</h2>
            <div className="account-actions">
              <button className="account-action-btn secondary">
                <span className="btn-icon">🔄</span>
                Cambiar Contraseña
              </button>
              <button className="account-action-btn secondary">
                <span className="btn-icon">📥</span>
                Descargar Datos
              </button>
              <button className="account-action-btn danger">
                <span className="btn-icon">🗑️</span>
                Eliminar Cuenta
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ProfilePage;
