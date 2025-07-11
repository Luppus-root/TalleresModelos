"use client";

import { useState, useEffect } from "react";
import { useApp } from "../App";
import "../styles/components/stats-section.css";

function StatsSection() {
  const { professionals } = useApp();
  const [animatedStats, setAnimatedStats] = useState({
    professionals: 0,
    services: 0,
    reviews: 0,
    satisfaction: 0,
  });

  useEffect(() => {
    const finalStats = {
      professionals: professionals.length || 150,
      services: 500,
      reviews: 2500,
      satisfaction: 98,
    };

    const animateStats = () => {
      const duration = 2000;
      const steps = 60;
      const stepDuration = duration / steps;

      let currentStep = 0;

      const interval = setInterval(() => {
        currentStep++;
        const progress = currentStep / steps;

        setAnimatedStats({
          professionals: Math.floor(finalStats.professionals * progress),
          services: Math.floor(finalStats.services * progress),
          reviews: Math.floor(finalStats.reviews * progress),
          satisfaction: Math.floor(finalStats.satisfaction * progress),
        });

        if (currentStep >= steps) {
          clearInterval(interval);
          setAnimatedStats(finalStats);
        }
      }, stepDuration);
    };

    const timer = setTimeout(animateStats, 500);
    return () => clearTimeout(timer);
  }, [professionals]);

  return (
    <section className="stats-section">
      <div className="stats-container">
        <div className="stat-card">
          <div className="stat-icon">👩‍💼</div>
          <div className="stat-number">{animatedStats.professionals}+</div>
          <div className="stat-label">Profesionales</div>
        </div>

        <div className="stat-card">
          <div className="stat-icon">✨</div>
          <div className="stat-number">{animatedStats.services}+</div>
          <div className="stat-label">Servicios</div>
        </div>

        <div className="stat-card">
          <div className="stat-icon">⭐</div>
          <div className="stat-number">{animatedStats.reviews}+</div>
          <div className="stat-label">Reseñas</div>
        </div>

        <div className="stat-card">
          <div className="stat-icon">😊</div>
          <div className="stat-number">{animatedStats.satisfaction}%</div>
          <div className="stat-label">Satisfacción</div>
        </div>
      </div>
    </section>
  );
}

export default StatsSection;
