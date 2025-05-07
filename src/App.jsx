import { useState } from "react";
import { Card, CardContent } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { MapPin, Navigation } from "lucide-react";

const locations = {
  A: "Humanidades",
  B: "Ágora",
  C: "Hacienda",
  D: "Negocios",
  E: "Auditorio",
  F: "Ingeniería",
  G: "Biblioteca",
  H: "Cafetería",
  I: "Servicios médicos",
  J: "Salud",
  K: "Alberca",
  L: "Gimnasio",
  M: "Sorteo",
  N: "Atletismo",
  O: "Templo del dolor",
};

export default function CampusNavigator() {
  const [start, setStart] = useState("");
  const [end, setEnd] = useState("");
  const [result, setResult] = useState(null);

  const handleNavigate = () => {
    if (!start || !end || start === end) return;
    // Lógica simulada. Sustituir por API o algoritmo real si se desea
    const fakePath = [start, "B", "G", end];
    const time = Math.floor(Math.random() * 15 + 5);
    setResult({ path: fakePath, time });
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-green-100 to-white p-6">
      <h1 className="text-3xl font-bold mb-6 text-center">Navegador UDLAP</h1>

      <div className="grid gap-4 md:grid-cols-2 max-w-3xl mx-auto">
        <Card>
          <CardContent className="p-4">
            <label className="block mb-2 font-semibold">Origen:</label>
            <select
              className="w-full border rounded p-2"
              value={start}
              onChange={(e) => setStart(e.target.value)}
            >
              <option value="">Selecciona origen</option>
              {Object.entries(locations).map(([key, name]) => (
                <option key={key} value={key}>
                  {key} - {name}
                </option>
              ))}
            </select>

            <label className="block mt-4 mb-2 font-semibold">Destino:</label>
            <select
              className="w-full border rounded p-2"
              value={end}
              onChange={(e) => setEnd(e.target.value)}
            >
              <option value="">Selecciona destino</option>
              {Object.entries(locations).map(([key, name]) => (
                <option key={key} value={key}>
                  {key} - {name}
                </option>
              ))}
            </select>

            <Button onClick={handleNavigate} className="w-full mt-6">
              <Navigation className="mr-2" /> Calcular Ruta
            </Button>
          </CardContent>
        </Card>

        {result && (
          <Card>
            <CardContent className="p-4">
              <h2 className="text-lg font-bold mb-2">Ruta Calculada</h2>
              <ul className="mb-2">
                {result.path.map((node, idx) => (
                  <li key={idx} className="flex items-center">
                    <MapPin className="h-4 w-4 mr-2 text-green-700" />
                    {node} - {locations[node]}
                  </li>
                ))}
              </ul>
              <p className="font-semibold">
                Tiempo estimado: {result.time} minutos
              </p>
            </CardContent>
          </Card>
        )}
      </div>
    </div>
  );
}
