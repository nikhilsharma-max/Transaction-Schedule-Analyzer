const mockData = {
  serializable: true,

  conflicts: [
    "R1(X) -> W2(X)"
  ],

  graph: {
    nodes: [
      { id: "T1" },
      { id: "T2" },
      { id: "T3" }
    ],

    edges: [
      {
        source: "T1",
        target: "T2"
      }
    ]
  },

  serialSchedules: [
    ["T1", "T2", "T3"],
    ["T1", "T3", "T2"],
    ["T3", "T1", "T2"]
  ]
};

export default mockData;