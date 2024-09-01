import * as React from "react";
import Box from "@mui/material/Box";
import Slider from "@mui/material/Slider";
import TextField from "@mui/material/TextField";

function valuetext(value: number) {
  return `${value}`;
}

export default function RangeSlider() {
  const [value, setValue] = React.useState<number[]>([20, 37]);

  const handleChange = (event: Event, newValue: number | number[]) => {
    setValue(newValue as number[]);
  };

  const handleInputChange =
    (index: number) => (event: React.ChangeEvent<HTMLInputElement>) => {
      const newValue = [...value];
      newValue[index] = Number(event.target.value);
      setValue(newValue);
    };

  return (
    <Box sx={{ width: 300 }}>
      <Slider
        getAriaLabel={() => "Temperature range"}
        value={value}
        onChange={handleChange}
        valueLabelDisplay="auto"
        getAriaValueText={valuetext}
        min={0}
        max={1000}
      />
      <Box sx={{ display: "flex", justifyContent: "space-between", mt: 2 }}>
        <TextField
          label="Min Value"
          value={value[0]}
          onChange={handleInputChange(0)}
          inputProps={{
            step: 10,
            min: 0,
            max: 1000,
            type: "number",
          }}
        />
        <TextField
          label="Max Value"
          value={value[1]}
          onChange={handleInputChange(1)}
          inputProps={{
            step: 10,
            min: 0,
            max: 1000,
            type: "number",
          }}
        />
      </Box>
    </Box>
  );
}
