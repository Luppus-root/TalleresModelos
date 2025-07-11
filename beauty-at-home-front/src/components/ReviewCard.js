import StarRating from "./StarRating";
import "../styles/components/review-card.css";
import "../styles/components/star-rating.css";

function ReviewCard({ review, services, index }) {
  const service = services.find((s) => s.id === review.serviceId);

  return (
    <div className="review-card" style={{ animationDelay: `${index * 0.1}s` }}>
      <div className="review-header">
        <div className="client-info">
          <div className="client-avatar">
            <span className="client-initials">{review.clientInitials}</span>
          </div>
          <div className="client-details">
            <span className="client-name">{review.clientInitials}</span>
            <span className="review-date">
              {new Date(review.date).toLocaleDateString()}
            </span>
          </div>
        </div>
        <StarRating rating={review.rating} />
      </div>

      <div className="review-content">
        <div className="service-info">
          <span className="service-icon">✨</span>
          <span className="service-name">{service?.name}</span>
        </div>
        <p className="review-comment">{review.comment}</p>

        {review.servicePhotos && review.servicePhotos.length > 0 && (
          <div className="review-photos">
            {review.servicePhotos.map((photo, photoIndex) => (
              <div key={photoIndex} className="review-photo-container">
                <img
                  src={photo || "/placeholder.svg"}
                  alt="Resultado del servicio"
                />
                <div className="photo-overlay">
                  <button className="photo-view-btn">👁️</button>
                </div>
              </div>
            ))}
          </div>
        )}
      </div>

      <div className="review-actions">
        <button className="review-action-btn">
          <span className="btn-icon">👍</span>
          <span>Útil</span>
        </button>
        <button className="review-action-btn">
          <span className="btn-icon">💬</span>
          <span>Responder</span>
        </button>
      </div>
    </div>
  );
}

export default ReviewCard;
