import Select from "../components/Select";
import Search from "../components/Search";
import BasicDatePicker from "../components/BasicDatePicker";
import RangeSlider from "../components/RangeSlider";

interface Props {
  elements: string[];
  selectLabel?: string;
  showSearch?: boolean;
  showDates?: boolean;
  showSlider?: boolean;
}

function FilterSection({
  elements,
  selectLabel,
  showSearch,
  showDates,
  showSlider,
}: Props) {
  return (
    <div className="d-flex justify-content-center">
      <form className="d-flex flex-wrap align-items-center gap-2 mb-4">
        <div className="col-auto d-flex align-items-center">
          <span className="me-2">{selectLabel}</span>
          <Select elements={elements} />
        </div>

        {showSearch === true && (
          <div className="col-auto">
            <Search />
          </div>
        )}

        {showDates === true && (
          <>
            <div className="col-auto">
              <BasicDatePicker label="Start Date" />
            </div>

            <div className="col-auto">
              <BasicDatePicker label="End Date" />
            </div>
          </>
        )}

        {showSlider === true && (
          <>
            <RangeSlider></RangeSlider>
          </>
        )}

        <button type="button" className="btn btn-primary">
          Filter
        </button>
      </form>
    </div>
  );
}

export default FilterSection;
