"use client";

import { useState } from "react";
import { useApp } from "../App";
import "../styles/pages/auth.css";

function LoginPage() {
  const { login, setCurrentView } = useApp();
  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });
  const [errors, setErrors] = useState({});
  const [isLoading, setIsLoading] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
    // Limpiar error cuando el usuario empiece a escribir
    if (errors[name]) {
      setErrors((prev) => ({
        ...prev,
        [name]: "",
      }));
    }
  };

  const validateForm = () => {
    const newErrors = {};

    if (!formData.email) {
      newErrors.email = "El email es requerido";
    } else if (!/\S+@\S+\.\S+/.test(formData.email)) {
      newErrors.email = "El email no es válido";
    }

    if (!formData.password) {
      newErrors.password = "La contraseña es requerida";
    } else if (formData.password.length < 6) {
      newErrors.password = "La contraseña debe tener al menos 6 caracteres";
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

    // Simular llamada a API
    setTimeout(() => {
      // Datos de usuario simulados
      const userData = {
        id: 1,
        name: "María García",
        email: formData.email,
        avatar: "/placeholder.svg?height=100&width=100",
        phone: "+57 300 123 4567",
        joinDate: "2023-01-15",
        bookingsCount: 12,
        favoriteCount: 5,
      };

      login(userData);
      setIsLoading(false);
    }, 1000);
  };

  return (
    <div className="auth-page">
      <div className="auth-container">
        <div className="auth-card">
          <div className="auth-header">
            <div className="auth-icon">
              <span>🔐</span>
            </div>
            <h1>Iniciar Sesión</h1>
            <p>Bienvenida de vuelta a BeautyAtHome</p>
          </div>

          <form className="auth-form" onSubmit={handleSubmit}>
            <div className="form-group">
              <label htmlFor="email">Email</label>
              <div className="input-container">
                <span className="input-icon">📧</span>
                <input
                  type="email"
                  id="email"
                  name="email"
                  value={formData.email}
                  onChange={handleChange}
                  placeholder="tu@email.com"
                  className={errors.email ? "error" : ""}
                />
              </div>
              {errors.email && (
                <span className="error-message">{errors.email}</span>
              )}
            </div>

            <div className="form-group">
              <label htmlFor="password">Contraseña</label>
              <div className="input-container">
                <span className="input-icon">🔒</span>
                <input
                  type="password"
                  id="password"
                  name="password"
                  value={formData.password}
                  onChange={handleChange}
                  placeholder="••••••••"
                  className={errors.password ? "error" : ""}
                />
              </div>
              {errors.password && (
                <span className="error-message">{errors.password}</span>
              )}
            </div>

            <button
              type="submit"
              className="auth-submit-btn"
              disabled={isLoading}
            >
              {isLoading ? (
                <>
                  <div className="spinner"></div>
                  Iniciando sesión...
                </>
              ) : (
                <>
                  <span className="btn-icon">🚀</span>
                  Iniciar Sesión
                </>
              )}
            </button>
          </form>

          <div className="auth-footer">
            <p>¿No tienes cuenta?</p>
            <button
              className="auth-link-btn"
              onClick={() => setCurrentView("register")}
            >
              Regístrate aquí
            </button>
          </div>

          <div className="demo-credentials">
            <h4>Credenciales de prueba:</h4>
            <p>
              <strong>Email:</strong> demo@beautyathome.com
            </p>
            <p>
              <strong>Contraseña:</strong> 123456
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default LoginPage;
