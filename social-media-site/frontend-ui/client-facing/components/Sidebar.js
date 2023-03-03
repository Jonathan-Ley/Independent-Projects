import React from "react";
import Image from "next/image";
import { ImUsers } from "react-icons/im";
import SidebarItem from "./SidebarItem";
import {
  MdGroups,
  MdOutlineOndemandVideo,
  MdOutlineExpandMore,
} from "react-icons/md";
import { AiOutlineShop } from "react-icons/ai";
import { BsStopwatch } from "react-icons/bs";

const Sidebar = () => {
  return (
    <div className="hidden lg:inline-flex flex-col py-2 pl-2 max-w-xl lg:min-w-[302px]">
      <div className="flex items-center space-x-2 py-3 pl-4 hover:bg-gray-100 rounded-l-xl cursor-pointer">
        <Image
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCf0yhvWf3eq6_06cO2_0kUoOCUZpTgZIzTA&usqp=CAU"
          height={50}
          width={40}
        />
        <p className="hidden sm:inline-flex font-medium">Jonathan Ley</p>
      </div>
      <SidebarItem Icon={ImUsers} value="Friends" />
      <SidebarItem Icon={MdGroups} value="Groups" />
      <SidebarItem Icon={MdOutlineOndemandVideo} value="Watch" />
      <SidebarItem Icon={AiOutlineShop} value="Shopping" />
      <SidebarItem Icon={BsStopwatch} value="Memories" />
      <SidebarItem Icon={MdOutlineExpandMore} value="See More" />
    </div>
  );
};

export default Sidebar;
