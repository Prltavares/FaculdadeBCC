// List of teams used by the app.
// Each team is an object with a name and a flag.
const teams = [
    { name: "Argentina", flag: "🇦🇷" },
    { name: "Brazil", flag: "🇧🇷" },
    { name: "Colombia", flag: "🇨🇴" },
    { name: "Ecuador", flag: "🇪🇨" },
    { name: "Paraguay", flag: "🇵🇾" },
    { name: "Uruguay", flag: "🇺🇾" },
    { name: "United States", flag: "🇺🇸" },
    { name: "Canada", flag: "🇨🇦" },
    { name: "Mexico", flag: "🇲🇽" },
    { name: "Panama", flag: "🇵🇦" },
    { name: "Curacao", flag: "🇨🇼" },
    { name: "Haiti", flag: "🇭🇹" },
    { name: "Algeria", flag: "🇩🇿" },
    { name: "Cape Verde", flag: "🇨🇻" },
    { name: "Ivory Coast", flag: "🇨🇮" },
    { name: "Egypt", flag: "🇪🇬" },
    { name: "Ghana", flag: "🇬🇭" },
    { name: "Morocco", flag: "🇲🇦" },
    { name: "Senegal", flag: "🇸🇳" },
    { name: "South Africa", flag: "🇿🇦" },
    { name: "Tunisia", flag: "🇹🇳" },
    { name: "Australia", flag: "🇦🇺" },
    { name: "Iran", flag: "🇮🇷" },
    { name: "Japan", flag: "🇯🇵" },
    { name: "Jordan", flag: "🇯🇴" },
    { name: "South Korea", flag: "🇰🇷" },
    { name: "Qatar", flag: "🇶🇦" },
    { name: "Saudi Arabia", flag: "🇸🇦" },
    { name: "Uzbekistan", flag: "🇺🇿" },
    { name: "New Zealand", flag: "🇳🇿" },
    { name: "Austria", flag: "🇦🇹" },
    { name: "Belgium", flag: "🇧🇪" },
    { name: "Croatia", flag: "🇭🇷" },
    { name: "England", flag: "🏴" },
    { name: "France", flag: "🇫🇷" },
    { name: "Germany", flag: "🇩🇪" },
    { name: "Netherlands", flag: "🇳🇱" },
    { name: "Norway", flag: "🇳🇴" },
    { name: "Portugal", flag: "🇵🇹" },
    { name: "Scotland", flag: "🏴" },
    { name: "Spain", flag: "🇪🇸" },
    { name: "Switzerland", flag: "🇨🇭" },
    { name: "Bosnia and Herzegovina", flag: "🇧🇦" },
    { name: "Czech Republic", flag: "🇨🇿" },
    { name: "Sweden", flag: "🇸🇪" },
    { name: "Turkey", flag: "🇹🇷" },
    { name: "Iraq", flag: "🇮🇶" },
    { name: "Democratic Republic of the Congo", flag: "🇨🇩" }
];

// Get the page elements that JavaScript will update.
const allTeamsContainer = document.getElementById("all-teams");
const favoriteTeamsContainer = document.getElementById("favorite-teams");
const emptyMessage = document.getElementById("empty-message");
const favoriteCount = document.getElementById("favorite-count");

// Load saved favorite team names from localStorage.
// If there is nothing saved yet, start with an empty array.
let favoriteTeams = JSON.parse(localStorage.getItem("favoriteTeams")) || [];

function saveFavorites() {
    // localStorage can only save text, so the array is converted to a string.
    localStorage.setItem("favoriteTeams", JSON.stringify(favoriteTeams));
}

function isFavorite(teamName) {
    // Check if a team name already exists in the favorites array.
    return favoriteTeams.includes(teamName);
}

function followTeam(teamName) {
    // Only add the team if it is not already selected.
    if (!isFavorite(teamName)) {
        favoriteTeams.push(teamName);
        saveFavorites();
        renderPage();
    }
}

function removeTeam(teamName) {
    // Keep every favorite except the one the user removed.
    favoriteTeams = favoriteTeams.filter(function (name) {
        return name !== teamName;
    });

    saveFavorites();
    renderPage();
}

function createTeamCard(team, isSelected, buttonText, buttonClass, buttonAction) {
    // Create the card and its child elements with DOM manipulation.
    const card = document.createElement("div");
    card.className = "team-card";

    if (isSelected) {
        card.classList.add("selected");
    }

    const flag = document.createElement("div");
    flag.className = "team-flag";
    flag.textContent = team.flag;

    const name = document.createElement("p");
    name.className = "team-name";
    name.textContent = team.name;

    const button = document.createElement("button");
    button.textContent = buttonText;

    if (buttonClass) {
        button.classList.add(buttonClass);
    }

    // Run the action passed into this function when the button is clicked.
    button.addEventListener("click", function () {
        buttonAction(team.name);
    });

    card.appendChild(flag);
    card.appendChild(name);
    card.appendChild(button);

    return card;
}

function renderAllTeams() {
    // Clear old cards before drawing the list again.
    allTeamsContainer.innerHTML = "";

    teams.forEach(function (team) {
        const selected = isFavorite(team.name);
        const buttonText = selected ? "Following" : "Follow";

        const card = createTeamCard(team, selected, buttonText, "", followTeam);
        allTeamsContainer.appendChild(card);
    });
}

function renderFavoriteTeams() {
    // Clear old favorite cards before drawing the list again.
    favoriteTeamsContainer.innerHTML = "";

    favoriteCount.textContent = favoriteTeams.length + " selected";
    emptyMessage.style.display = favoriteTeams.length === 0 ? "block" : "none";

    favoriteTeams.forEach(function (teamName) {
        const team = teams.find(function (item) {
            return item.name === teamName;
        });

        if (team) {
            const card = createTeamCard(team, true, "Remove", "remove-button", removeTeam);
            favoriteTeamsContainer.appendChild(card);
        }
    });
}

function renderPage() {
    renderFavoriteTeams();
    renderAllTeams();
}

// Draw the app when the page first loads.
renderPage();
