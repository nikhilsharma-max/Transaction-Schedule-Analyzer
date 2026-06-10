import "../styles/result.css";

function SchedulePreview({ schedule }) {

  return (
    <div className="result-card">

      <h2>
        Generated Schedule
      </h2>

      <p
        style={{
          fontFamily: "monospace",
          fontSize: "1.25rem",
          fontWeight: "700",
          color: "#2563eb"
        }}
      >
        {schedule}
      </p>

    </div>
  );
}

export default SchedulePreview;