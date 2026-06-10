const exampleSchedules = {

  serializable: [

    {
      operationType: "READ",
      transactionId: "T1",
      dataItem: "X"
    },

    {
      operationType: "WRITE",
      transactionId: "T2",
      dataItem: "X"
    },

    {
      operationType: "READ",
      transactionId: "T3",
      dataItem: "Y"
    }

  ],

  nonSerializable: [

    {
      operationType: "WRITE",
      transactionId: "T1",
      dataItem: "X"
    },

    {
      operationType: "READ",
      transactionId: "T2",
      dataItem: "X"
    },

    {
      operationType: "WRITE",
      transactionId: "T2",
      dataItem: "Y"
    },

    {
      operationType: "READ",
      transactionId: "T1",
      dataItem: "Y"
    }

  ]

};

export default exampleSchedules;