import React from "react";
import { useNavigate } from "react-router-dom";

const NavBar = () => {
  const navigate = useNavigate();

  return (
    <div className="bg-emerald-500 rounded-lg mt-2 ml-2 mr-2 mb-6 shadow-md">
      <div className="h-16 px-10 flex items-center">
        <p
          onClick={() => navigate("/")}
          className="text-white font-bold cursor-pointer"
        >
          EzGoin Landscape Employee Management System
        </p>
        {/* <img className="" src="data:image/png;base64,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"/> */}
      </div>
    </div>
  );
};

export default NavBar;
