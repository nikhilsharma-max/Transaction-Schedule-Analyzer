import { useState } from "react";
import "../styles/input.css";

function ScheduleInput({ onAnalyze }) {

  const [operations, setOperations] = useState([
    {
      operationType: "READ",
      transactionId: 1,
      dataItem: "X"
    }
  ]);

  const removeOperation = (index) => {

    setOperations(
      operations.filter(
        (_, i) => i !== index
      )
    );
  };

  const addOperation = () => {

    setOperations([
      ...operations,
      {
        operationType: "READ",
        transactionId: 1,
        dataItem: "X"
      }
    ]);
  };

  const updateOperation = (
    index,
    field,
    value
  ) => {

    const updated = [...operations];

    updated[index][field] = value;

    setOperations(updated);
  };

  const loadSerializableExample = () => {

    setOperations([
      {
        operationType: "READ",
        transactionId: 1,
        dataItem: "X"
      },
      {
        operationType: "WRITE",
        transactionId: 2,
        dataItem: "X"
      }
    ]);
  };

  const loadNonSerializableExample = () => {

    setOperations([
      {
        operationType: "READ",
        transactionId: 1,
        dataItem: "X"
      },
      {
        operationType: "WRITE",
        transactionId: 2,
        dataItem: "X"
      },
      {
        operationType: "READ",
        transactionId: 2,
        dataItem: "Y"
      },
      {
        operationType: "WRITE",
        transactionId: 1,
        dataItem: "Y"
      }
    ]);
  };

  const handleAnalyze = () => {
    onAnalyze(operations);
  };

  return (

    <div className="input-container">

      <h2>Build Schedule</h2>

      {operations.map((op, index) => (

        <div
          className="operation-row"
          key={index}
        >

          <select
            value={op.operationType}
            onChange={(e) =>
              updateOperation(
                index,
                "operationType",
                e.target.value
              )
            }
          >
            <option value="READ">
              READ
            </option>

            <option value="WRITE">
              WRITE
            </option>
          </select>

          <select
            value={op.transactionId}
            onChange={(e) =>
              updateOperation(
                index,
                "transactionId",
                Number(e.target.value)
              )
            }
          >
            {[1, 2, 3, 4, 5].map(id => (
              <option
                key={id}
                value={id}
              >
                T{id}
              </option>
            ))}
          </select>

          <select
            value={op.dataItem}
            onChange={(e) =>
              updateOperation(
                index,
                "dataItem",
                e.target.value
              )
            }
          >
            {["X", "Y", "Z", "A", "B", "C"]
              .map(item => (

                <option
                  key={item}
                  value={item}
                >
                  {item}
                </option>

              ))}
          </select>

          <button
            onClick={() =>
              removeOperation(index)
            }
          >
            Delete
          </button>

        </div>

      ))}

      <div
        style={{
          display: "flex",
          gap: "10px",
          flexWrap: "wrap",
          justifyContent: "center",
          marginTop: "20px"
        }}
      >

        <button
          className="add-btn"
          onClick={addOperation}
        >
          + Add Operation
        </button>

        <button
          className="add-btn"
          onClick={handleAnalyze}
        >
          Analyze Schedule
        </button>

        <button
          className="add-btn"
          onClick={loadSerializableExample}
        >
          Load Serializable Example
        </button>

        <button
          className="add-btn"
          onClick={loadNonSerializableExample}
        >
          Load Non-Serializable Example
        </button>

      </div>

    </div>
  );
}

export default ScheduleInput;