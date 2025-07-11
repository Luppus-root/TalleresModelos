import HeroSection from "./HeroSection";
import FilterSection from "./FilterSection";
import ProfessionalGrid from "./ProfessionalGrid";
import StatsSection from "./StatsSection";
import "../styles/pages/home.css";

function HomePage({
  professionals,
  filters,
  setFilters,
  onViewProfessional,
  areas,
  services,
}) {
  return (
    <div className="home-page">
      <HeroSection />
      <StatsSection professionals={professionals} />
      <FilterSection
        filters={filters}
        setFilters={setFilters}
        areas={areas}
        services={services}
      />
      <ProfessionalGrid
        professionals={professionals}
        onViewProfessional={onViewProfessional}
      />
    </div>
  );
}

export default HomePage;
