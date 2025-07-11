"use client";

import { useState } from "react";
import { useApp } from "../App";
import "../styles/components/filter-section.css";

function FilterSection() {
  const { filters, setFilters, areas } = useApp();
  const [isExpanded, setIsExpanded] = useState(false);

  return (
    <section className="filter-section">
      <div className="filter-container">
        <div className="filter-header">
          <h3>Encuentra tu profesional ideal</h3>
          <button
            className="filter-toggle"
            onClick={() => setIsExpanded(!isExpanded)}
          >
            <span>Filtros avanzados</span>
            <span className={`toggle-icon ${isExpanded ? "expanded" : ""}`}>
              ⚙️
            </span>
          </button>
        </div>

        <div className="search-bar">
          <div className="search-input-container">
            <span className="search-icon">🔍</span>
            <input
              type="text"
              placeholder="Buscar por nombre o servicio..."
              value={filters.search}
              onChange={(e) =>
                setFilters({ ...filters, search: e.target.value })
              }
              className="search-input"
            />
            {filters.search && (
              <button
                className="clear-search"
                onClick={() => setFilters({ ...filters, search: "" })}
              >
                ✕
              </button>
            )}
          </div>
        </div>

        <div className={`advanced-filters ${isExpanded ? "expanded" : ""}`}>
          <div className="filter-grid">
            <div className="filter-group">
              <label>📍 Área</label>
              <select
                value={filters.area}
                onChange={(e) =>
                  setFilters({ ...filters, area: e.target.value })
                }
              >
                <option value="">Todas las áreas</option>
                {areas.map((area) => (
                  <option key={area} value={area}>
                    {area}
                  </option>
                ))}
              </select>
            </div>

            <div className="filter-group">
              <label>⭐ Calificación</label>
              <select
                value={filters.rating}
                onChange={(e) =>
                  setFilters({ ...filters, rating: e.target.value })
                }
              >
                <option value="">Cualquier calificación</option>
                <option value="4.5">4.5+ estrellas</option>
                <option value="4.0">4.0+ estrellas</option>
                <option value="3.5">3.5+ estrellas</option>
              </select>
            </div>

            <div className="filter-group">
              <label>💰 Precio</label>
              <select
                value={filters.priceRange}
                onChange={(e) =>
                  setFilters({ ...filters, priceRange: e.target.value })
                }
              >
                <option value="">Cualquier precio</option>
                <option value="low">Hasta $50,000</option>
                <option value="medium">$50,000 - $100,000</option>
                <option value="high">Más de $100,000</option>
              </select>
            </div>

            <div className="filter-group">
              <label>🎯 Especialidad</label>
              <select
                value={filters.service}
                onChange={(e) =>
                  setFilters({ ...filters, service: e.target.value })
                }
              >
                <option value="">Todas las especialidades</option>
                <option value="hair">Cabello</option>
                <option value="nails">Uñas</option>
                <option value="makeup">Maquillaje</option>
              </select>
            </div>
          </div>

          <div className="filter-actions">
            <button
              className="clear-filters"
              onClick={() =>
                setFilters({
                  area: "",
                  service: "",
                  priceRange: "",
                  rating: "",
                  search: "",
                })
              }
            >
              Limpiar filtros
            </button>
          </div>
        </div>
      </div>
    </section>
  );
}

export default FilterSection;
