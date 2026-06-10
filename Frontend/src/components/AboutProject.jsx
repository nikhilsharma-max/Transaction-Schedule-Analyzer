import "../styles/result.css";

function AboutProject() {

  return (
    <div className="result-card">

      <h2>
        How This Analyzer Works
      </h2>

      <ol>

        <li>
          Parse all operations from the schedule.
        </li>

        <li>
          Detect conflicting operations.
        </li>

        <li>
          Build the precedence graph.
        </li>

        <li>
          Detect cycles in the graph.
        </li>

        <li>
          If no cycle exists, generate all valid
          serial schedules using topological sort.
        </li>

      </ol>

    </div>
  );
}

export default AboutProject;