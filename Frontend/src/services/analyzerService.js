
import axios from "axios";

const API_URL = import.meta.env.VITE_API_URL;
export const analyzeSchedule = async (schedule) => {

  const response = await axios.post(
    API_URL,
    { schedule }
  );

  return response.data;
};