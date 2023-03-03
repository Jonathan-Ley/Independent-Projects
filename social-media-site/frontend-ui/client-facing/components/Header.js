import Image from "next/image";
import React from "react";
import { BiSearchAlt2, BiHome } from "react-icons/bi";
import { RiFlag2Line } from "react-icons/ri";
import { MdOutlineOndemandVideo, MdOutlineExpandMore } from "react-icons/md";
import { AiOutlineShopping, AiFillMessage, AiFillBell } from "react-icons/ai";
import { IoGameControllerOutline } from "react-icons/io5";
import { CgMenuGridO } from "react-icons/cg";

const Header = () => {
  return (
    <div className="bg-white flex items-center p-2 shadow-md top-0 sticky z-50 h-16">
      {/* left component */}
      <div className="flex min-w-fit">
        <Image
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCf0yhvWf3eq6_06cO2_0kUoOCUZpTgZIzTA&usqp=CAU"
          height={50}
          width={40}
        />
        <div className="flex items-center space-x-3 px-3 ml-3 rounded-full bg-slate-200 text-gray-600">
          <BiSearchAlt2 size={20} />
          <input
            className="hidden lg:inline-flex bg-transparent focus:outline-none"
            type="text"
            placeholder="Search LeoBook... "
          />
        </div>
      </div>
      {/* center component */}
      <div className="flex flex-grow justify-center mx-2">
        <div className="flex items-center">
          <div className="flex items-center h-14 px-4 md:px-10 rounded-md md:hover:bg-gray-200 cursor-pointer">
            <BiHome className="mx-auto" size={20} />
          </div>
          <div className="flex items-center h-14 px-4 md:px-10 rounded-md md:hover:bg-gray-200 cursor-pointer">
            <RiFlag2Line className="mx-auto" size={20} />
          </div>
          <div className="flex items-center h-14 px-4 md:px-10 rounded-md md:hover:bg-gray-200 cursor-pointer">
            <MdOutlineOndemandVideo className="mx-auto" size={20} />
          </div>
          <div className="flex items-center h-14 px-4 md:px-10 rounded-md md:hover:bg-gray-200 cursor-pointer">
            <AiOutlineShopping className="mx-auto" size={20} />
          </div>
          <div className="flex items-center h-14 px-4 md:px-10 rounded-md md:hover:bg-gray-200 cursor-pointer">
            <IoGameControllerOutline className="mx-auto" size={20} />
          </div>
        </div>
      </div>
      {/* right component */}
      <div className="flex items-center justify-end min-w-fit space-x-2">
        <Image
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCf0yhvWf3eq6_06cO2_0kUoOCUZpTgZIzTA&usqp=CAU"
          height={40}
          width={40}
        />
        <p className="hidden md:inline-flex font-bold texr-sm whitespace-nowrap p-3 max-w-xs">
          Jonathan Ley
        </p>
        <CgMenuGridO
          size={15}
          className="hidden lg:inline-flex h-10 w-10 bg-slate-200 text-gray-600 rounded-full p-2 cursor-pointer hover:bg-gray-300"
        />
        <AiFillBell
          size={15}
          className="hidden lg:inline-flex h-10 w-10 bg-slate-200 text-gray-600 rounded-full p-2 cursor-pointer hover:bg-gray-300"
        />
        <AiFillMessage
          size={15}
          className="hidden lg:inline-flex h-10 w-10 bg-slate-200 text-gray-600 rounded-full p-2 cursor-pointer hover:bg-gray-300"
        />
        <MdOutlineExpandMore
          size={15}
          className="hidden lg:inline-flex h-10 w-10 bg-slate-200 text-gray-600 rounded-full p-2 cursor-pointer hover:bg-gray-300"
        />
      </div>
    </div>
  );
};

export default Header;
