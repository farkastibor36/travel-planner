import { useState } from "react";

function MainPage() {
    const [searchData, setSearchData] = useState({
        from: "",
        to: "",
        date: "",
        passengers: 1,
    });

    const handleChange = (e) => {
        setSearchData({
            ...searchData,
            [e.target.name]: e.target.value,
        });
    };

    const handleSearch = (e) => {
        e.preventDefault();
        console.log("Flight search:", searchData);
        // Itt később API hívás jöhet a járatok lekéréséhez
    };

    return (
        <div className="main-page">
            <h1>Flight search</h1>

            <form onSubmit={handleSearch} className="flight-search-form">
                <input
                    type="text"
                    name="from"
                    placeholder="From"
                    value={searchData.from}
                    onChange={handleChange}
                />

                <input
                    type="text"
                    name="to"
                    placeholder="To"
                    value={searchData.to}
                    onChange={handleChange}
                />

                <input
                    type="date"
                    name="date"
                    value={searchData.date}
                    onChange={handleChange}
                />

                <input
                    type="number"
                    name="passengers"
                    min="1"
                    value={searchData.passengers}
                    onChange={handleChange}
                />

                <button type="submit">Search flights</button>
            </form>
        </div>
    );
}

export default MainPage;