import Image from "next/image";
import React from "react";
import { BiSearchAlt2 } from "react-icons/bi";

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
      {/* right component */}
    </div>
  );
};

export default Header;
