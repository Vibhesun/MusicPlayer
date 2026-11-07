-- ==========================================================
-- SonicFlow - Tamil Hit Songs Database Seed Script
-- Target Database: onlinemusicplayer
-- ==========================================================

USE `onlinemusicplayer`;

-- 1. Insert Default User (if not already present)
INSERT IGNORE INTO `users` (`id`, `username`, `email`, `password_hash`, `role`)
VALUES (1, 'TamilMusicFan', 'fan@tamilbeats.com', '$2a$10$samplehash123', 'USER');

-- 2. Insert Popular Tamil Hit Songs
INSERT INTO `songs` (`title`, `artist`, `album`, `genre`, `duration_seconds`, `audio_path`, `cover_path`)
VALUES
('Hukum - Thalaivar Alappara', 'Anirudh Ravichander, Super Subu', 'Jailer', 'Tamil Mass', 207, 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3', 'https://images.unsplash.com/photo-1514525253161-7a46d19cd819?w=500&auto=format&fit=crop&q=80'),
('Arabic Kuthu - Halamithi Habibo', 'Anirudh Ravichander, Jonita Gandhi', 'Beast', 'Tamil Kuthu', 280, 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3', 'https://images.unsplash.com/photo-1518709268805-4e9042af9f23?w=500&auto=format&fit=crop&q=80'),
('Rowdy Baby', 'Dhanush, Dhee, Yuvan Shankar Raja', 'Maari 2', 'Tamil Folk', 284, 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3', 'https://images.unsplash.com/photo-1470225620780-dba8ba36b745?w=500&auto=format&fit=crop&q=80'),
('Enjoy Enjaami', 'Dhee ft. Arivu, Santhosh Narayanan', 'Maajja Independent', 'Tamil Indie', 288, 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-4.mp3', 'https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=500&auto=format&fit=crop&q=80'),
('Vaathi Coming', 'Anirudh Ravichander, Gana Balachandar', 'Master', 'Tamil Kuthu', 230, 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-8.mp3', 'https://images.unsplash.com/photo-1618005182384-a83a8bd57fbe?w=500&auto=format&fit=crop&q=80'),
('Nenjukkul Peidhidum', 'Hariharan, Devan Ekambaram, Harris Jayaraj', 'Vaaranam Aayiram', 'Tamil Melody', 370, 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-9.mp3', 'https://images.unsplash.com/photo-1511671782779-c97d3d27a1d4?w=500&auto=format&fit=crop&q=80'),
('Kannazhaga - The Kiss of Love', 'Dhanush, Shruti Haasan, Anirudh', '3', 'Tamil Melody', 205, 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-15.mp3', 'https://images.unsplash.com/photo-1508700115892-45ecd05ae2ad?w=500&auto=format&fit=crop&q=80'),
('Marakkuma Nenjam', 'A.R. Rahman', 'Vendhu Thanindhathu Kaadu', 'Tamil Soul', 255, 'https://www.soundhelix.com/examples/mp3/SoundHelix-Song-16.mp3', 'https://images.unsplash.com/photo-1518495973542-4542c06a5843?w=500&auto=format&fit=crop&q=80');

-- 3. Insert Default Tamil Hits Playlist
INSERT IGNORE INTO `playlists` (`id`, `name`, `user_id`, `created_at`)
VALUES (1, 'Kollywood Top Hits 🔥', 1, NOW());

-- 4. Add Songs into Playlist
INSERT IGNORE INTO `playlist_songs` (`id`, `playlist_id`, `song_id`, `position`)
VALUES
(1, 1, 1, 1),
(2, 1, 2, 2),
(3, 1, 3, 3),
(4, 1, 4, 4),
(5, 1, 5, 5);
