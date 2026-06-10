function ResultCard({ title, children }) {
  return (
    <div className="result-card">
      <h2>{title}</h2>
      {children}
    </div>
  );
}

export default ResultCard;