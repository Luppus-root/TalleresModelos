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
    let starClass = "star empty";
    if (i < fullStars) {
      starClass = "star filled";
    } else if (i === fullStars && hasHalfStar) {
      starClass = "star half";
    }

    stars.push(
      <button
        key={i}
        className={`${starClass} ${size} ${interactive ? "interactive" : ""}`}
        onClick={() => interactive && onRatingChange && onRatingChange(i + 1)}
        disabled={!interactive}
      >
        <span className="star-icon">⭐</span>
      </button>
    );
  }

  return <div className="star-rating">{stars}</div>;
}

export default StarRating;
