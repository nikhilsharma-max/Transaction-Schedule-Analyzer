import ResultCard from "./ResultCard";

function ConflictList({ conflicts }) {
  return (
    <ResultCard title="Conflicts">

      {conflicts.length === 0 ? (
        <p>No Conflicts</p>
      ) : (
<div className="conflict-list">
  {conflicts.map((conflict, index) => (
    <p key={index}>{conflict}</p>
  ))}
</div>
      )}

    </ResultCard>
  );
}

export default ConflictList;