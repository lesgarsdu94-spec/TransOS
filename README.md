# 🚌 FleetFlow GIS | Plateforme de Gestion de Réseau de Transport

[![Android Build](https://github.com/votre-repo/fleetflow/actions/workflows/android.yml/badge.svg)](https://github.com/votre-repo/fleetflow/actions)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

**FleetFlow** est une solution logicielle intégrée pour l'exploitation des réseaux de transport public. Elle combine la télémétrie temps réel des véhicules et l'analyse spatiale avancée pour optimiser la mobilité urbaine.

## 🚀 Piliers du Projet

* **Gestion de Flotte :** Suivi du cycle de vie, maintenance préventive et télémétrie.
* **SIG & Cartographie :** Visualisation haute performance (Mapbox), géofencing et couches topologiques.
* **Standardisation :** Flux de données basés sur les standards **GTFS** (statique) et **GTFS-RT** (SIRI).
* **Intermodalité :** Gestion des hubs multi-modaux et hiérarchisation des lignes.

## 🛠 Stack Technique

* **Mobile :** Android (Kotlin), Clean Architecture, MVVM, Jetpack Compose.
* **SIG :** Mapbox Maps SDK v10+, Turf.js (calculs géométriques).
* **Backend (Architecture cible) :** Python (FastAPI) / PostgreSQL + PostGIS.
* **CI/CD :** GitHub Actions pour les builds automatisés.

## 📦 Installation (Android)

1. **Cloner le dépôt**
   ```bash
   git clone [https://github.com/votre-user/votre-repo.git](https://github.com/votre-user/votre-repo.git)
