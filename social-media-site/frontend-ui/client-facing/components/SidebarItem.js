import React from "react";
import { ImUsers } from "react-icons/im";

const SidebarItem = ({ Icon, value }) => {
  return (
    <div className="flex items-center space-x-2 py-3 pl-4 hover:bg-slate-400 rounded-l-xl cursor-pointer">
      <Icon className="h-8 w-8 text-blue-600" />
      <p className="hidden sm:inline-flex font-medium">{value}</p>
    </div>
  );
};

export default SidebarItem;
