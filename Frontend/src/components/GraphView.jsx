import ReactFlow, {
  Background,
  Controls
} from "reactflow";

import "reactflow/dist/style.css";
import "../styles/graph.css";

import "reactflow/dist/style.css";
import "../styles/graph.css";

function GraphView({ graph }) {

  const nodes =
    graph.nodes.map(
      (node, index) => ({
        id: node.id,

        position: {
          x: index * 250,
          y: 100
        },

        data: {
          label: node.id
        }
      })
    );

  const edges =
    graph.edges.map(
      (edge, index) => ({
        id: `e${index}`,

        source: edge.source,

        target: edge.target,

        animated: true
      })
    );

  return (
    <div className="graph-card">

      <h2>Precedence Graph</h2>

      <div className="graph-container">

        <ReactFlow
          nodes={nodes}
          edges={edges}
          fitView
        >

          <Background />
          <Controls />

        </ReactFlow>

      </div>

    </div>
  );
}

export default GraphView;