"use client";

import { useState, useEffect, useRef } from "react";
import { useApp } from "../App";
import "../styles/pages/chat.css";

function ChatPage() {
  const { selectedProfessionalForChat, setCurrentView, user } = useApp();
  const [messages, setMessages] = useState([]);
  const [newMessage, setNewMessage] = useState("");
  const messagesEndRef = useRef(null);

  useEffect(() => {
    if (selectedProfessionalForChat) {
      // Simular historial de chat
      setMessages([
        {
          id: 1,
          sender: selectedProfessionalForChat.name,
          text: `¡Hola! Soy ${selectedProfessionalForChat.name}. ¿En qué puedo ayudarte hoy?`,
          timestamp: new Date(Date.now() - 60000 * 5).toISOString(), // 5 minutos atrás
        },
        {
          id: 2,
          sender: user?.name || "Tú",
          text: `Hola ${
            selectedProfessionalForChat.name
          }, estoy interesada en tus servicios de ${
            selectedProfessionalForChat.services.length > 0
              ? "corte y coloración"
              : "belleza"
          }.`,
          timestamp: new Date(Date.now() - 60000 * 3).toISOString(), // 3 minutos atrás
        },
      ]);
    }
  }, [selectedProfessionalForChat, user]);

  useEffect(() => {
    messagesEndRef.current?.scrollIntoView({ behavior: "smooth" });
  }, [messages]);

  const handleSendMessage = (e) => {
    e.preventDefault();
    if (newMessage.trim() === "") return;

    const message = {
      id: Date.now(),
      sender: user?.name || "Tú",
      text: newMessage,
      timestamp: new Date().toISOString(),
    };
    setMessages((prev) => [...prev, message]);
    setNewMessage("");

    // Simular respuesta del profesional después de un breve retraso
    setTimeout(() => {
      const reply = {
        id: Date.now() + 1,
        sender: selectedProfessionalForChat.name,
        text: "Entendido. ¿Tienes alguna fecha o servicio específico en mente?",
        timestamp: new Date().toISOString(),
      };
      setMessages((prev) => [...prev, reply]);
    }, 1500);
  };

  if (!selectedProfessionalForChat) {
    return (
      <div className="chat-error">
        <div className="error-content">
          <div className="error-icon">💬</div>
          <h2>No se pudo iniciar el chat</h2>
          <p>Por favor, selecciona un profesional para contactar.</p>
          <button className="error-btn" onClick={() => setCurrentView("home")}>
            <span className="btn-icon">🏠</span>
            Volver al inicio
          </button>
        </div>
      </div>
    );
  }

  return (
    <div className="chat-page">
      <div className="page-container">
        <div className="chat-header">
          <button
            className="back-button"
            onClick={() => setCurrentView("professional")}
          >
            <span className="back-icon">←</span>
            <span>Volver</span>
          </button>
          <div className="professional-chat-info">
            <img
              src={selectedProfessionalForChat.photo || "/placeholder.svg"}
              alt={selectedProfessionalForChat.name}
              className="chat-professional-avatar"
            />
            <div className="chat-professional-details">
              <h2 className="chat-professional-name">
                {selectedProfessionalForChat.name}
              </h2>
              <span className="chat-status online">En línea</span>
            </div>
          </div>
          <button className="chat-options-btn">
            <span className="btn-icon">⋮</span>
          </button>
        </div>

        <div className="chat-messages">
          {messages.map((msg) => (
            <div
              key={msg.id}
              className={`message-bubble ${
                msg.sender === user?.name || "Tú" ? "sent" : "received"
              }`}
            >
              <div className="message-content">
                <p>{msg.text}</p>
                <span className="message-timestamp">
                  {new Date(msg.timestamp).toLocaleTimeString([], {
                    hour: "2-digit",
                    minute: "2-digit",
                  })}
                </span>
              </div>
            </div>
          ))}
          <div ref={messagesEndRef} />
        </div>

        <form className="chat-input-form" onSubmit={handleSendMessage}>
          <input
            type="text"
            value={newMessage}
            onChange={(e) => setNewMessage(e.target.value)}
            placeholder="Escribe tu mensaje..."
            className="chat-input"
          />
          <button type="submit" className="send-message-btn">
            <span className="btn-icon">✉️</span>
            Enviar
          </button>
        </form>
      </div>
    </div>
  );
}

export default ChatPage;
