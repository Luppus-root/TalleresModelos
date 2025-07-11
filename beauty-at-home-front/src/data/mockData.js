export const mockData = {
  professionals: [
    {
      id: 1,
      name: "Isabella Martínez",
      photo: "/placeholder.svg?height=300&width=300",
      experience:
        "Estilista profesional con más de 10 años de experiencia internacional. Especializada en técnicas de coloración avanzada y cortes de vanguardia. Certificada por L'Oréal Professional Academy y Wella Professionals.",
      rating: 4.9,
      totalReviews: 247,
      isSponsored: true,
      sponsorBrand: "L'Oréal Professional",
      coverageAreas: ["Chapinero", "Zona Rosa", "Chicó", "Rosales"],
      services: [1, 2, 3],
    },
    {
      id: 2,
      name: "Santiago Rodríguez",
      photo: "/placeholder.svg?height=300&width=300",
      experience:
        "Master Barber con formación en técnicas clásicas y modernas. Especialista en cortes masculinos de precisión y cuidado de barba. 8 años perfeccionando el arte de la barbería tradicional.",
      rating: 4.8,
      totalReviews: 189,
      isSponsored: false,
      sponsorBrand: null,
      coverageAreas: ["Centro", "La Candelaria", "Teusaquillo", "Macarena"],
      services: [4, 5],
    },
    {
      id: 3,
      name: "Valentina Herrera",
      photo: "/placeholder.svg?height=300&width=300",
      experience:
        "Nail Artist reconocida internacionalmente. Especialista en nail art de alta gama y técnicas de extensión. Embajadora oficial de OPI y creadora de tendencias en redes sociales.",
      rating: 4.95,
      totalReviews: 312,
      isSponsored: true,
      sponsorBrand: "OPI",
      coverageAreas: ["Zona Norte", "Usaquén", "Chapinero", "Chicó"],
      services: [6, 7, 8],
    },
    {
      id: 4,
      name: "Camila Torres",
      photo: "/placeholder.svg?height=300&width=300",
      experience:
        "Makeup Artist profesional con experiencia en moda, televisión y eventos especiales. Especializada en maquillaje de novia y técnicas de contouring avanzado.",
      rating: 4.7,
      totalReviews: 156,
      isSponsored: true,
      sponsorBrand: "MAC Cosmetics",
      coverageAreas: ["Zona Rosa", "Chapinero", "Usaquén"],
      services: [9, 10],
    },
  ],
  services: [
    {
      id: 1,
      name: "Corte y Peinado Premium",
      description:
        "Experiencia completa de transformación capilar. Incluye consulta personalizada, lavado con productos premium, corte según tu tipo de rostro, peinado profesional y productos de acabado de lujo.",
      price: 85000,
      duration: 120,
      images: [
        "/placeholder.svg?height=400&width=400",
        "/placeholder.svg?height=400&width=400",
        "/placeholder.svg?height=400&width=400",
      ],
    },
    {
      id: 2,
      name: "Coloración Artística",
      description:
        "Transformación de color personalizada con técnicas avanzadas. Incluye decoloración profesional, aplicación de color, tratamiento post-color y peinado final. Productos L'Oréal Professional exclusivos.",
      price: 180000,
      duration: 240,
      images: [
        "/placeholder.svg?height=400&width=400",
        "/placeholder.svg?height=400&width=400",
      ],
    },
    {
      id: 3,
      name: "Tratamiento Reconstructivo",
      description:
        "Terapia intensiva para cabello dañado. Tratamiento con keratina, botox capilar y aceites nutritivos. Ideal para cabello teñido, maltratado o con falta de brillo.",
      price: 95000,
      duration: 90,
      images: ["/placeholder.svg?height=400&width=400"],
    },
    {
      id: 4,
      name: "Corte Masculino Signature",
      description:
        "Corte masculino de precisión con técnicas tradicionales y modernas. Incluye lavado, corte con tijera y navaja, arreglo de patillas y acabado con productos premium.",
      price: 45000,
      duration: 60,
      images: [
        "/placeholder.svg?height=400&width=400",
        "/placeholder.svg?height=400&width=400",
      ],
    },
    {
      id: 5,
      name: "Cuidado de Barba Deluxe",
      description:
        "Servicio completo de barbería tradicional. Incluye recorte, perfilado, afeitado con navaja, masaje facial, hidratación y aceites aromáticos especializados.",
      price: 35000,
      duration: 45,
      images: ["/placeholder.svg?height=400&width=400"],
    },
    {
      id: 6,
      name: "Manicure Spa Premium",
      description:
        "Experiencia de lujo para tus manos. Incluye exfoliación, hidratación profunda, cuidado de cutículas, masaje relajante y esmaltado con productos OPI de alta gama.",
      price: 45000,
      duration: 75,
      images: [
        "/placeholder.svg?height=400&width=400",
        "/placeholder.svg?height=400&width=400",
      ],
    },
    {
      id: 7,
      name: "Pedicure Terapéutico",
      description:
        "Tratamiento completo para pies cansados. Incluye baño relajante, exfoliación, eliminación de callosidades, masaje terapéutico, hidratación y esmaltado profesional.",
      price: 55000,
      duration: 90,
      images: ["/placeholder.svg?height=400&width=400"],
    },
    {
      id: 8,
      name: "Nail Art Exclusivo",
      description:
        "Diseños únicos y personalizados en tus uñas. Técnicas avanzadas con gel, acrílico, decoraciones 3D, cristales Swarovski y efectos especiales. Arte en tus manos.",
      price: 75000,
      duration: 120,
      images: [
        "/placeholder.svg?height=400&width=400",
        "/placeholder.svg?height=400&width=400",
        "/placeholder.svg?height=400&width=400",
      ],
    },
    {
      id: 9,
      name: "Maquillaje Social",
      description:
        "Maquillaje profesional para eventos especiales. Incluye preparación de piel, maquillaje completo adaptado al evento y ocasión, con productos MAC de alta gama.",
      price: 120000,
      duration: 90,
      images: [
        "/placeholder.svg?height=400&width=400",
        "/placeholder.svg?height=400&width=400",
      ],
    },
    {
      id: 10,
      name: "Maquillaje de Novia",
      description:
        "Experiencia completa para el día más especial. Incluye prueba previa, maquillaje el día del evento, retoques y productos de larga duración. Perfección garantizada.",
      price: 250000,
      duration: 150,
      images: [
        "/placeholder.svg?height=400&width=400",
        "/placeholder.svg?height=400&width=400",
      ],
    },
  ],
  reviews: [
    {
      id: 1,
      professionalId: 1,
      serviceId: 1,
      rating: 5,
      comment:
        "¡Increíble experiencia! Isabella es una verdadera artista. Mi cabello nunca se había visto tan bien. La atención al detalle y el profesionalismo son excepcionales. Definitivamente regresaré y la recomendaré a todas mis amigas.",
      date: "2024-01-20",
      clientInitials: "M.R.",
      servicePhotos: [
        "/placeholder.svg?height=300&width=300",
        "/placeholder.svg?height=300&width=300",
      ],
    },
    {
      id: 2,
      professionalId: 1,
      serviceId: 2,
      rating: 5,
      comment:
        "El cambio de color superó todas mis expectativas. Isabella entendió perfectamente lo que quería y el resultado es espectacular. Los productos L'Oréal que usa son de primera calidad.",
      date: "2024-01-18",
      clientInitials: "A.L.",
      servicePhotos: ["/placeholder.svg?height=300&width=300"],
    },
    {
      id: 3,
      professionalId: 2,
      serviceId: 4,
      rating: 5,
      comment:
        "Santiago es el mejor barbero que he encontrado en la ciudad. Su técnica es impecable y la experiencia es muy relajante. El ambiente que crea es único.",
      date: "2024-01-19",
      clientInitials: "C.M.",
      servicePhotos: ["/placeholder.svg?height=300&width=300"],
    },
    {
      id: 4,
      professionalId: 3,
      serviceId: 8,
      rating: 5,
      comment:
        "Valentina es una verdadera artista del nail art. Los diseños que crea son únicos y la calidad es excepcional. Vale cada peso invertido.",
      date: "2024-01-17",
      clientInitials: "L.S.",
      servicePhotos: [
        "/placeholder.svg?height=300&width=300",
        "/placeholder.svg?height=300&width=300",
      ],
    },
  ],
  bookings: [
    {
      id: 1,
      userId: 1,
      professionalId: 1,
      serviceId: 1,
      professionalName: "Isabella Martínez",
      serviceName: "Corte y Peinado Premium",
      servicePrice: 85000,
      serviceDuration: 120,
      date: "2024-02-15",
      time: "14:00",
      address: "Calle 85 #15-20, Chapinero",
      notes: "Prefiero corte en capas",
      status: "confirmed",
      createdAt: "2024-01-25T10:30:00Z",
    },
    {
      id: 2,
      userId: 1,
      professionalId: 3,
      serviceId: 6,
      professionalName: "Valentina Herrera",
      serviceName: "Manicure Spa Premium",
      servicePrice: 45000,
      serviceDuration: 75,
      date: "2024-02-10",
      time: "16:00",
      address: "Carrera 11 #93-45, Usaquén",
      notes: "",
      status: "completed",
      createdAt: "2024-01-20T15:45:00Z",
    },
  ],
  favorites: [
    {
      id: 1,
      userId: 1,
      professionalId: 1,
      addedAt: "2024-01-15T10:30:00Z",
    },
    {
      id: 2,
      userId: 1,
      professionalId: 3,
      addedAt: "2024-01-20T14:20:00Z",
    },
  ],
  notifications: [
    {
      id: 1,
      type: "booking_confirmed",
      title: "¡Cita confirmada!",
      message:
        "Tu cita con Isabella Martínez ha sido confirmada para el 15 de febrero a las 14:00",
      date: "2024-01-25T10:30:00Z",
      read: false,
    },
    {
      id: 2,
      type: "booking_reminder",
      title: "Recordatorio de cita",
      message:
        "Tu cita con Valentina Herrera es mañana a las 16:00. ¡No olvides confirmar tu dirección!",
      date: "2024-02-09T09:00:00Z",
      read: false,
    },
    {
      id: 3,
      type: "new_review",
      title: "Nueva reseña disponible",
      message: "Isabella Martínez ha recibido una nueva reseña de 5 estrellas",
      date: "2024-01-20T16:45:00Z",
      read: true,
    },
    {
      id: 4,
      type: "promotion",
      title: "¡Oferta especial!",
      message:
        "20% de descuento en servicios de manicure durante febrero. ¡No te lo pierdas!",
      date: "2024-02-01T08:00:00Z",
      read: false,
    },
    {
      id: 5,
      type: "booking_cancelled",
      title: "Cita cancelada",
      message:
        "Tu cita del 12 de febrero ha sido cancelada. Puedes reagendar cuando gustes.",
      date: "2024-02-10T11:30:00Z",
      read: true,
    },
  ],
  areas: [
    "Chapinero",
    "Zona Rosa",
    "Chicó",
    "Centro",
    "La Candelaria",
    "Teusaquillo",
    "Zona Norte",
    "Usaquén",
    "Suba",
    "Engativá",
    "Rosales",
    "Macarena",
  ],
};
