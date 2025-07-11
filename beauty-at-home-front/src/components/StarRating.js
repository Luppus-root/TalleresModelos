"use client";

import "../styles/components/star-rating.css";

function StarRating({
  rating,
  size = "normal",
  interactive = false,
  onRatingChange,
}) {
  const stars = [];
  const fullStars = Math.floor(rating);
  const hasHalfStar = rating % 1 !== 0;

  for (let i = 0; i < 5; i++) {
    let starEmoji = "☆"; // Estrella vacía
    if (i < fullStars) {
      starEmoji = "⭐"; // Estrella llena
    } else if (i === fullStars && hasHalfStar) {
      starEmoji = "🌟"; // Estrella media
    }

    stars.push(
      <button
        key={i}
        className={`star ${size} ${interactive ? "interactive" : ""}`}
        onClick={() => interactive && onRatingChange && onRatingChange(i + 1)}
        disabled={!interactive}
        aria-label={`${i + 1} star${i + 1 === 1 ? "" : "s"}`}
      >
        <span className="star-icon">{starEmoji}</span>
      </button>
    );
  }

  return <div className="star-rating">{stars}</div>;
}

export default StarRating;
