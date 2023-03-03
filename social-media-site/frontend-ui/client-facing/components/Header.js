import Image from "next/image";
import React from "react";
import { BiSearchAlt2, BiHome } from "react-icons/bi";
import { RiFlag2Line } from "react-icons/ri";
import { MdOutlineOndemandVideo } from "react-icons/md";
import { AiOutlineShopping } from "react-icons/ai";
import { IoGameControllerOutline } from "react-icons/io5";

const Header = () => {
  return (
    <div className="bg-white flex items-center p-2 shadow-md top-0 sticky z-50 h-16">
      {/* left component */}
      <div className="flex min-w-fit">
        <Image
          src="https://d3ui957tjb5bqd.cloudfront.net/uploads/2017/01/C-Bird-by-George-Bokhua.jpg"
          height={60}
          width={80}
        />
        <div className="flex items-center space-x-2 px-2 ml-2 rounded-full bg-slate-200 text-gray-500">
          <BiSearchAlt2 size={20} />
          <input
            className="hidden lg:inline-flex bg-transparent focus:outline-none"
            type="text"
            placeholder="Search "
          />
        </div>
      </div>
      {/* center component */}
      <div className="flex flex-grow justify-center mx-2">
        <div className="flex items-center">
          <div className="flex items-center h-14 px-4 md:px-10 rounded-md md:hover:bg-gray-200 cursor-pointer">
            <BiHome className="mx-auto" size={25} />
          </div>
          <div className="flex items-center h-14 px-4 md:px-10 rounded-md md:hover:bg-gray-200 cursor-pointer">
            <RiFlag2Line className="mx-auto" size={25} />
          </div>
          <div className="flex items-center h-14 px-4 md:px-10 rounded-md md:hover:bg-gray-200 cursor-pointer">
            <MdOutlineOndemandVideo className="mx-auto" size={25} />
          </div>
          <div className="flex items-center h-14 px-4 md:px-10 rounded-md md:hover:bg-gray-200 cursor-pointer">
            <AiOutlineShopping className="mx-auto" size={25} />
          </div>
          <div className="flex items-center h-14 px-4 md:px-10 rounded-md md:hover:bg-gray-200 cursor-pointer">
            <IoGameControllerOutline className="mx-auto" size={25} />
          </div>
        </div>
      </div>
      {/* right component */}
    </div>
  );
};

export default Header;
