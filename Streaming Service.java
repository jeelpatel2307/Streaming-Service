streaming_service/
│   ├── main.py
│   ├── media.py
│   └── README.md





class Media:
    def __init__(self, title, duration):
        self.title = title
        self.duration = duration

    def play(self):
        pass

class Movie(Media):
    def __init__(self, title, duration, director):
        super().__init__(title, duration)
        self.director = director

    def play(self):
        print(f"Playing movie: {self.title}")

class TVShow(Media):
    def __init__(self, title, duration, season, episode):
        super().__init__(title, duration)
        self.season = season
        self.episode = episode

    def play(self):
        print(f"Playing TV show: {self.title}, Season {self.season}, Episode {self.episode}")





from media import Movie, TVShow

class StreamingService:
    def __init__(self):
        self.catalog = []

    def add_to_catalog(self, media):
        self.catalog.append(media)

    def browse_catalog(self):
        for media in self.catalog:
            print(media.title)

    def play_media(self, title):
        for media in self.catalog:
            if media.title == title:
                media.play()
                break
        else:
            print("Media not found in catalog.")

def main():
    # Create a streaming service instance
    netflix = StreamingService()

    # Add movies and TV shows to the catalog
    netflix.add_to_catalog(Movie("Inception", 150, "Christopher Nolan"))
    netflix.add_to_catalog(Movie("The Dark Knight", 152, "Christopher Nolan"))
    netflix.add_to_catalog(TVShow("Breaking Bad", 45, 5, 10))
    netflix.add_to_catalog(TVShow("Stranger Things", 60, 3, 8))

    # Browse and play media
    print("Available titles:")
    netflix.browse_catalog()
    print("\nPlaying media:")
    netflix.play_media("Inception")
    netflix.play_media("Breaking Bad")
    netflix.play_media("The Crown")  # Testing media not in catalog

if __name__ == "__main__":
    main()
