import { useState } from "react";
import mockData from "../data/mockData";
import {
  analyzeSchedule
} from "../services/analyzerService";
import ScheduleInput from "../components/ScheduleInput";
import SerializableStatus from "../components/SerializableStatus";
import ConflictList from "../components/ConflictList";
import SerialScheduleList from "../components/SerialScheduleList";
import GraphView from "../components/GraphView";
import SchedulePreview from "../components/SchedulePreview";
import AboutProject from "../components/AboutProject";

import "../styles/home.css";

function Home() {
  const [loading, setLoading] =
  useState(false);
  const [result, setResult] =
    useState(null);

  const [generatedSchedule,
    setGeneratedSchedule] =
    useState("");

  const handleAnalyze =
  async (operations) => {
    setLoading(true);
      const schedule =
        operations
          .map((op) => {

            const operation =
              op.operationType === "READ"
                ? "R"
                : "W";

            return `${operation}${op.transactionId}(${op.dataItem})`;

          })
          .join(" ");

      console.log(schedule);

      setGeneratedSchedule(
        schedule
      );

try {

  const result =
    await analyzeSchedule(
      schedule
    );
setResult(result);
setLoading(false);

} catch (error) {
setLoading(false);
  console.error(error);

  alert(
    "Backend connection failed"
  );
}
    };

  return (

    <div className="home-container">

      <h1 className="main-title">
        Transaction Schedule Analyzer
      </h1>

      <div className="schedule-section">

        <ScheduleInput
        
          onAnalyze={
            handleAnalyze
          }
        />
{loading && (
  <div className="loading-box">
    Analyzing Schedule...
  </div>
)}
      </div>

      {!result && (

        <div className="empty-state">

          No Schedule Analyzed Yet

        </div>

      )}

      {result && (

  <div className="results-section">

  <SchedulePreview
    schedule={generatedSchedule}
  />

  <SerializableStatus
    serializable={result.serializable}
  />

  <ConflictList
    conflicts={result.conflicts}
  />

  <SerialScheduleList
    serialSchedules={result.serialSchedules}
  />

{result.graph && (
  <GraphView
    graph={result.graph}
  />
)}

  <AboutProject />

</div>

      )}

    </div>
  );
}

export default Home;