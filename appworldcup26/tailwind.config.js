/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./app/**/*.{js,jsx}",
    "./components/**/*.{js,jsx}",
  ],
  theme: {
    extend: {
      colors: {
        cup: {
          blue: "#27b7ff",
          green: "#39ff88",
          dark: "#07111f",
        },
      },
    },
  },
  plugins: [],
};
