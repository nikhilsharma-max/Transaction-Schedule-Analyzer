import ResultCard from "./ResultCard";

function SerialScheduleList({
  serialSchedules
}) {
  return (
    <ResultCard
      title="All Valid Serial Schedules"
    >

      {serialSchedules.map(
        (schedule, index) => (

          <p key={index}>
            {index + 1}.{" "}
            {schedule.join(" → ")}
          </p>

        )
      )}

    </ResultCard>
  );
}

export default SerialScheduleList;