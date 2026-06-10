import "../styles/result.css";

function SerializableStatus({
  serializable
}) {
  return (
    <div className="result-card status-card">

      <h2>Serializable Status</h2>

      <p>
        {serializable
          ? "✅ Serializable"
          : "❌ Not Serializable"}
      </p>

    </div>
  );
}

export default SerializableStatus;