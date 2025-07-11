import ProfessionalCard from "./ProfessionalCard";
import { useApp } from "../App";
import "../styles/components/professional-card.css";

function ProfessionalGrid() {
  const { professionals, handleViewProfessional } = useApp();

  return (
    <section className="professionals-section">
      <div className="section-header">
        <h2>Nuestros Profesionales</h2>
        <p>Descubre talento excepcional cerca de ti</p>
      </div>

      <div className="professionals-grid">
        {professionals.map((professional, index) => (
          <ProfessionalCard
            key={professional.id}
            professional={professional}
            onView={() => handleViewProfessional(professional)}
            index={index}
          />
        ))}
      </div>

      {professionals.length === 0 && (
        <div className="no-results">
          <div className="no-results-icon">🔍</div>
          <h3>No encontramos profesionales</h3>
          <p>Intenta ajustar tus filtros de búsqueda</p>
        </div>
      )}
    </section>
  );
}

export default ProfessionalGrid;
