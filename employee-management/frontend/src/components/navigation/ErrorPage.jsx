import React from "react";
import { useNavigate } from "react-router-dom";

const ErrorPage = () => {
  const navigate = useNavigate();

  return (
    <div>
      <p className="font-semibold text-lg text-center">
        Sorry for the inconvenience, but the page you requested doesn't exist!
      </p>
      <button
        className="rounded text-white font-semibold bg-emerald-500 hover:bg-emerald-700 ml-20 py-2 px-6 cursor-pointer"
        onClick={() => navigate("/")}
      >
        To Home Page
      </button>
    </div>
  );
};

export default ErrorPage;
