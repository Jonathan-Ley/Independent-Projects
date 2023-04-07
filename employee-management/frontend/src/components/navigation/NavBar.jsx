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
      </div>
    </div>
  );
};

export default NavBar;
