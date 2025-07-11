import HeroSection from "../components/HeroSection";
import FilterSection from "../components/FilterSection";
import ProfessionalGrid from "../components/ProfessionalGrid";
import StatsSection from "../components/StatsSection";
import { useApp } from "../App";

function HomePage() {
  const {
    professionals,
    filters,
    setFilters,
    handleViewProfessional,
    areas,
    services,
  } = useApp();

  return (
    <div className="home-page">
      <HeroSection />
      <StatsSection />
      <FilterSection />
      <ProfessionalGrid />
    </div>
  );
}

export default HomePage;
