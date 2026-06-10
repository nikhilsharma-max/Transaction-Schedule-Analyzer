
import axios from "axios";

const API_URL = "http://localhost:8080/analyze";

export const analyzeSchedule = async (schedule) => {

  const response = await axios.post(
    API_URL,
    { schedule }
  );

  return response.data;
};