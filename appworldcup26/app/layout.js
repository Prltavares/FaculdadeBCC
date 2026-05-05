import "./globals.css";

export const metadata = {
  title: "Copa 2026 Tracker",
  description: "Acompanhe seleções, grupos e jogos da Copa do Mundo de 2026.",
};

export default function RootLayout({ children }) {
  return (
    <html lang="pt-BR">
      <body>{children}</body>
    </html>
  );
}
